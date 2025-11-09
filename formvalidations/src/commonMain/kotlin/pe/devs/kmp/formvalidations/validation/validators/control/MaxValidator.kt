package pe.devs.kmp.formvalidations.validation.validators.control

import org.jetbrains.compose.resources.StringResource
import pe.devs.kmp.formvalidations.exception.ValidationException
import pe.devs.kmp.formvalidations.formvalidations.generated.resources.Res
import pe.devs.kmp.formvalidations.formvalidations.generated.resources.validator_max
import pe.devs.kmp.formvalidations.validation.abstracts.FormControlValidator

class MaxValidator(private val max: Number) : FormControlValidator() {

    override fun isValid(value: String): Boolean {
        val number = value.toDoubleOrNull() ?: return false
        return number <= max.toDouble()
    }

    override fun getErrorMessage(label: StringResource, value: String): ValidationException {
        return ValidationException(Res.string.validator_max, label, this.max)
    }
}
