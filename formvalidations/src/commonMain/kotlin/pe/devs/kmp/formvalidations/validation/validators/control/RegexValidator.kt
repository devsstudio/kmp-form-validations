package pe.devs.kmp.formvalidations.validation.validators.control

import pe.devs.kmp.formvalidations.validation.abstracts.FormControlValidator
import pe.devs.kmp.formvalidations.exception.ValidationException
import org.jetbrains.compose.resources.StringResource
import pe.devs.kmp.formvalidations.formvalidations.generated.resources.Res
import pe.devs.kmp.formvalidations.formvalidations.generated.resources.validator_regex

class RegexValidator(private val pattern: String) : FormControlValidator() {

    override fun isValid(value: String): Boolean {
        val regex = Regex(pattern)
        return regex.matches(value)
    }

    override fun getErrorMessage(label: StringResource, value: String): ValidationException {
        return ValidationException(Res.string.validator_regex, label)
    }
}