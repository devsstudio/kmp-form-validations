package pe.devs.kmp.formvalidations.validation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import pe.devs.kmp.formvalidations.validation.abstracts.FormControlValidator
import pe.devs.kmp.formvalidations.validation.exception.ValidationException
import org.jetbrains.compose.resources.StringResource

class FormControl (
    val labelResource: StringResource,
    val initialValue: String = "",
    val formControlValidators: List<FormControlValidator>
) {
    private var error: MutableState<ValidationException?> = mutableStateOf(null)
    private var currentValue: MutableState<String> = mutableStateOf("")

    init {
        currentValue.value = initialValue
    }

    @Throws(ValidationException::class)
    fun validate(): Boolean {
        error.value = null
        formControlValidators.forEach {
            it.setLabel(labelResource)
            try {
                it.validate(currentValue.value)
            } catch(ex: ValidationException) {
                error.value = ex
                return false
            }
        }
        return true
    }

    fun setValue(value: String): FormControl {
        currentValue.value = value
        return this
    }

    fun getValue(): String {
        return currentValue.value
    }

    fun setError(error: ValidationException?): FormControl {
        this.error.value = error
        return this
    }

    fun getError(): ValidationException? {
        return this.error.value
    }

    fun reset() {
        currentValue.value = this.initialValue
        error.value = null
    }
}