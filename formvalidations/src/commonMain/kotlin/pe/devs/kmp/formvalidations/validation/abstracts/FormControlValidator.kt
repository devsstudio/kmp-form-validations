package pe.devs.kmp.formvalidations.validation.abstracts

import org.jetbrains.compose.resources.StringResource
import pe.devs.kmp.formvalidations.exception.ValidationException
import pe.devs.kmp.formvalidations.formvalidations.generated.resources.Res
import pe.devs.kmp.formvalidations.formvalidations.generated.resources.validator_this_value

abstract class FormControlValidator {

    private var label: StringResource? = null

    abstract fun isValid(value: String): Boolean

    protected abstract fun getErrorMessage(label: StringResource, value: String): ValidationException

    fun setLabel(label: StringResource){
        this.label = label
    }

    @Throws(ValidationException::class)
    fun validate(value: String) {
        val valid = isValid(value)

        if(!valid){
            throw getErrorMessage(label?: Res.string.validator_this_value, value)
        }
    }
}