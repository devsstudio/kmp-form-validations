package pe.devs.kmp.formvalidations.validation.validators.control

import pe.devs.kmp.formvalidations.validation.abstracts.FormControlValidator
import pe.devs.kmp.formvalidations.validation.exception.ValidationException
import org.jetbrains.compose.resources.StringResource
import pe.devs.kmp.formvalidations.formvalidations.generated.resources.Res
import pe.devs.kmp.formvalidations.formvalidations.generated.resources.validator_email

class EmailValidator : FormControlValidator() {

    override fun isValid(value: String): Boolean {
        val emailRegex = Regex("^\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(\\.\\w{2,3})+$")
        return emailRegex.matches(value)
    }

    override fun getErrorResource(label: StringResource, value: String): ValidationException {
        return ValidationException(Res.string.validator_email, label)
    }
}