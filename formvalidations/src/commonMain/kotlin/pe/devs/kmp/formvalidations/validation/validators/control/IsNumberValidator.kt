package pe.devs.kmp.formvalidations.validation.validators.control

import org.jetbrains.compose.resources.StringResource
import pe.devs.kmp.formvalidations.exception.ValidationException
import pe.devs.kmp.formvalidations.formvalidations.generated.resources.Res
import pe.devs.kmp.formvalidations.formvalidations.generated.resources.validator_is_number
import pe.devs.kmp.formvalidations.validation.abstracts.FormControlValidator

class IsNumberValidator : FormControlValidator() {

    override fun isValid(value: String): Boolean {
        return value.toDoubleOrNull() != null
    }

    override fun getErrorMessage(label: StringResource, value: String): ValidationException {
        return ValidationException(Res.string.validator_is_number, label)
    }
}
