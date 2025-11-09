package pe.devs.kmp.formvalidations.validation.validators.control

import kotlinx.datetime.LocalDate
import org.jetbrains.compose.resources.StringResource
import pe.devs.kmp.formvalidations.formvalidations.generated.resources.Res
import pe.devs.kmp.formvalidations.formvalidations.generated.resources.validator_is_date
import pe.devs.kmp.formvalidations.validation.abstracts.FormControlValidator
import pe.devs.kmp.formvalidations.exception.ValidationException

class IsDateValidator(
    private val formatHint: String = "YYYY-MM-DD"
) : FormControlValidator() {

    override fun isValid(value: String): Boolean {
        return try {
            LocalDate.parse(value)
            true
        } catch (e: Exception) {
            false
        }
    }

    override fun getErrorMessage(label: StringResource, value: String): ValidationException {
        return ValidationException(Res.string.validator_is_date, label, formatHint)
    }
}
