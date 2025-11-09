package pe.devs.kmp.formvalidations.validation.abstracts

import pe.devs.kmp.formvalidations.classes.FormControl
import pe.devs.kmp.formvalidations.exception.ValidationException
import org.jetbrains.compose.resources.StringResource
import pe.devs.kmp.formvalidations.formvalidations.generated.resources.Res
import pe.devs.kmp.formvalidations.formvalidations.generated.resources.validator_this_value

abstract class FormGroupValidator(val target: String) {

    abstract fun isValid(controls: Map<String, FormControl>): Boolean

    protected abstract fun getErrorResource(label: StringResource): ValidationException

    @Throws(ValidationException::class)
    fun validate(controls: Map<String, FormControl>) {
        val valid = isValid(controls)

        if(!valid){
            throw getErrorResource(controls[target]?.labelResource ?: Res.string.validator_this_value)
        }
    }
}