package pe.devs.kmp.formvalidations.validation.abstracts

import pe.devs.kmp.formvalidations.validation.exception.ValidationException
import org.jetbrains.compose.resources.StringResource
import pe.devs.kmp.formvalidations.formvalidations.generated.resources.Res
import pe.devs.kmp.formvalidations.formvalidations.generated.resources.validator_this_value

abstract class FormControlValidator {

    private var label: StringResource? = null

    abstract fun isValid(value: String): Boolean

    protected abstract fun getErrorResource(label: StringResource, value: String): ValidationException

    fun setLabel(label: StringResource){
        this.label = label
    }

    @Throws(ValidationException::class)
    fun validate(value: String) {
        val valid = isValid(value)

        if(!valid){
            throw getErrorResource(label?: Res.string.validator_this_value, value)
        }
    }
}