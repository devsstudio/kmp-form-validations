package pe.devs.kmp.formvalidations.classes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import pe.devs.kmp.formvalidations.validation.abstracts.FormControlValidator
import org.jetbrains.compose.resources.StringResource
import pe.devs.kmp.formvalidations.exception.ValidationException

class FormControl (
    private val initialValue: String = ""
) {
    lateinit var labelResource: StringResource
    var formControlValidators: List<FormControlValidator> = emptyList()

    private var error: MutableState<ValidationException?> = mutableStateOf(null)

    private var errorMessage: MutableState<String?> = mutableStateOf(null)
    private var currentValue: MutableState<String> = mutableStateOf("")

    init {
        currentValue.value = initialValue
    }

    @Throws(ValidationException::class)
    fun validate(): Boolean {
        error.value = null
        errorMessage.value = null
        formControlValidators.forEach {
            it.setLabel(labelResource)
            try {
                it.validate(currentValue.value)
            } catch (ex: ValidationException) {
                error.value = ex
                return false
            }
        }
        return true
    }

    fun getInitialValue(): String {
        return this.initialValue
    }

    fun setValue(value: String): FormControl {
        currentValue.value = value
        return this
    }

    fun getValue(): String {
        return currentValue.value
    }

    fun setError(error: ValidationException): FormControl {
        this.error.value = error
        return this
    }

    fun setErrorMessage(errorMessage: String?): FormControl {
        this.errorMessage.value = errorMessage
        return this
    }

    fun getErrorMessage(): String? {
        return this.errorMessage.value
    }

    @Composable
    fun resolveErrorMessage(): String? {
        //Si hay error de validación resolvemos ese
        if (this.error.value != null) {
            this.errorMessage.value = this.error.value?.resolveMessage()
        }
        //Si no mostramos el actual
        return this.errorMessage.value
    }

    fun reset() {
        currentValue.value = this.initialValue
        error.value = null
    }
}