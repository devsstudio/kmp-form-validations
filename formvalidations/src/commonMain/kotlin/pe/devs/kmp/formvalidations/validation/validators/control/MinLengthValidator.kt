package pe.devs.kmp.formvalidations.validation.validators.control

import pe.devs.kmp.formvalidations.validation.abstracts.FormControlValidator
import pe.devs.kmp.formvalidations.validation.exception.ValidationException
import org.jetbrains.compose.resources.StringResource
import pe.devs.kmp.formvalidations.formvalidations.generated.resources.Res
import pe.devs.kmp.formvalidations.formvalidations.generated.resources.validator_min_length

class MinLengthValidator(private val min: Int) : FormControlValidator() {

    override fun isValid(value: String): Boolean {
        return value.length >= min
    }

    override fun getErrorResource(label: StringResource, value: String): ValidationException {
        return ValidationException(Res.string.validator_min_length, label, this.min)
    }
}