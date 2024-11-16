package pe.devs.kmp.formvalidations.validation.validators.group

import pe.devs.kmp.formvalidations.validation.FormControl
import pe.devs.kmp.formvalidations.validation.abstracts.FormGroupValidator
import pe.devs.kmp.formvalidations.validation.exception.ValidationException
import org.jetbrains.compose.resources.StringResource
import pe.devs.kmp.formvalidations.formvalidations.generated.resources.Res
import pe.devs.kmp.formvalidations.formvalidations.generated.resources.validator_passwords_must_match

class PasswordsMustMatchValidator(private val source: String, target: String) : FormGroupValidator(target) {

    override fun isValid(controls: Map<String, FormControl>): Boolean {
        return (controls[source]?.getValue() ?: "") == (controls[target]?.getValue() ?: "")
    }

    override fun getErrorResource(label: StringResource): ValidationException {
        return ValidationException(Res.string.validator_passwords_must_match, label)
    }
}