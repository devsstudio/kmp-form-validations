package pe.devs.kmp.formvalidations.validation.validators.control

import org.jetbrains.compose.resources.StringResource
import pe.devs.kmp.formvalidations.exception.ValidationException
import pe.devs.kmp.formvalidations.formvalidations.generated.resources.Res
import pe.devs.kmp.formvalidations.formvalidations.generated.resources.validator_min
import pe.devs.kmp.formvalidations.validation.abstracts.FormControlValidator

class MinValidator(private val min: Number) : FormControlValidator() {

    override fun isValid(value: String): Boolean {
        val number = value.toDoubleOrNull() ?: return false
        return number >= min.toDouble()
    }

    override fun getErrorMessage(label: StringResource, value: String): ValidationException {
        return ValidationException(Res.string.validator_min, label, this.min)
    }
}