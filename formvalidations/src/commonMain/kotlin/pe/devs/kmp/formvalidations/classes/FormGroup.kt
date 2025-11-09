package pe.devs.kmp.formvalidations.classes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.Saver
import pe.devs.kmp.formvalidations.exception.ValidationException
import pe.devs.kmp.formvalidations.validation.abstracts.FormGroupValidator

class FormGroup (
    private val controls: Map<String, FormControl>,
) {
    var formGroupValidators: List<FormGroupValidator> = emptyList()

    companion object {
        //El saver solo debe guardar valores nativos sino fallará en Android
        fun getSaver(): Saver<FormGroup, Map<String, Any>> {
            return Saver<FormGroup, Map<String, Any>>(
                save = { formGroup ->
                    mapOf(
                        "controls" to formGroup.controls.mapValues { (_, formControl) ->
                            mapOf(
                                "initialValue" to formControl.getInitialValue(),
                                "value" to formControl.getValue(),
                                "errorMessage" to formControl.getErrorMessage(),
                            )
                        }
                    )
                },
                restore = { restoredMap ->
                    val controls = restoredMap["controls"] as Map<String, Map<String, Any>>
                    FormGroup(
                        controls = controls.mapValues { (_, controlValues) ->
                            FormControl(
                                initialValue = controlValues["initialValue"] as String
                            )
                                .setValue(controlValues["value"] as String)
                                .setErrorMessage(controlValues["errorMessage"] as? String?)
                        }
                    )
                }
            )
        }
    }

    fun getControl(attribute: String): FormControl? {
        return controls[attribute]
    }

    @Composable
    fun validate(
        onValidate: (Boolean) -> Unit,
        finally: (() -> Unit)? = null
    ) {
        var isValid = true
        //var error: ValidationException? = null
        //val cleaned: MutableMap<String, Any> = mutableMapOf()
        for ((key, control) in controls) {
            if (!control.validate()) {
                isValid = false
            }
        }
        if (isValid) {
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