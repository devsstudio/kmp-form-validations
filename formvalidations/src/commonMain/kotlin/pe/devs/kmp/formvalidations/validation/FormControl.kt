package pe.devs.kmp.formvalidations.validation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import pe.devs.kmp.formvalidations.validation.abstracts.FormControlValidator
import pe.devs.kmp.formvalidations.validation.exception.ValidationException
import org.jetbrains.compose.resources.StringResource

class FormControl (
    val labelResource: StringResource,
    var error: MutableState<ValidationException?> = mutableStateOf(null),
    var initialValue: MutableState<String> = mutableStateOf(""),
    val formControlValidators: List<FormControlValidator>
) {
    @Throws(ValidationException::class)
    fun validate(): Boolean {
        error.value = null
        formControlValidators.forEach {
            it.setLabel(labelResource)
            try {
                it.validate(initialValue.value)
            } catch(ex: ValidationException) {
                error.value = ex
                return false
            }
        }
        return true
    }
}