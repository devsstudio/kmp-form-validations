package pe.devs.kmp.formvalidations.validation

import androidx.compose.runtime.saveable.Saver
import org.jetbrains.compose.resources.StringResource
import pe.devs.kmp.formvalidations.validation.abstracts.FormControlValidator
import pe.devs.kmp.formvalidations.validation.abstracts.FormGroupValidator
import pe.devs.kmp.formvalidations.validation.exception.ValidationException

class FormGroup (
    private val controls: Map<String, FormControl>,
    private val formGroupValidators: List<FormGroupValidator> = emptyList()
) {
    companion object {
        fun getSaver(): Saver<FormGroup, Map<String, Any>> {
            return Saver<FormGroup, Map<String, Any>>(
                save = { formGroup ->
                    mapOf(
                        "controls" to formGroup.controls.mapValues { (_, formControl) ->
                            mapOf(
                                "labelResource" to formControl.labelResource,
                                "initialValue" to formControl.initialValue,
                                "formControlValidators" to formControl.formControlValidators,
                                //Valores privados
                                "value" to formControl.getValue(),
                                "error" to formControl.getError(),
                            )
                        }
                    )
                },
                restore = { restoredMap ->
                    val controls = restoredMap["controls"] as Map<String, Map<String, Any>>
                    FormGroup(
                        controls = controls.mapValues { (_, controlValues) ->
                            FormControl(
                                labelResource = controlValues["labelResource"] as StringResource,
                                initialValue = controlValues["initialValue"] as String,
                                formControlValidators = controlValues["formControlValidators"] as List<FormControlValidator>,
                            )
                                .setValue(controlValues["value"] as String)
                                .setError(controlValues["error"] as? ValidationException)
                        }
                    )
                }
            )
        }
    }

    fun getControl(attribute: String): FormControl? {
        return controls[attribute]
    }

    fun validate(
        onValidate: (Boolean) -> Unit,
        finally: (() -> Unit)? = null
    ) {
        var isValid = true
        //var error: ValidationException? = null
        //val cleaned: MutableMap<String, Any> = mutableMapOf()
        for ((key, control) in controls) {
            if(!control.validate()) {
                isValid = false
            }
        }
        if(isValid) {
            for (validator in formGroupValidators) {
                try {
                    validator.validate(controls)
                } catch (ex: ValidationException) {
                    controls[validator.target]?.setError(ex)
                    isValid = false
                    break
                }
            }
        }

        onValidate(isValid)
        if (finally != null) {
            finally()
        }
    }

    fun getValues(): Map<String, String> {
        val values = HashMap<String, String>()
        for ((key, control) in controls) {
            values[key] = control.getValue()
        }
        return values.toMap()
    }

    fun reset() {
        for ((_, control) in controls) {
            control.reset()
        }
    }
}