package pe.devs.kmp.formvalidations.data

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import pe.devs.kmp.formvalidations.classes.FormControl
import pe.devs.kmp.formvalidations.classes.FormGroup
import pe.devs.kmp.formvalidations.validation.abstracts.FormGroupValidator

class FormGroupData(
    private val controls: Map<String, FormControlData>,
    private val formGroupValidators: List<FormGroupValidator> = emptyList()
) {
    @Composable
    fun generateFormGroup(): FormGroup {
        val formGroup: FormGroup by rememberSaveable(stateSaver = FormGroup.getSaver()) {
            mutableStateOf(
                FormGroup(
                    controls = this.controls.mapValues { (_, formControlData) ->
                        FormControl(
                            initialValue = formControlData.initialValue
                        )
                    }
                )
            )
        }

        this.controls.mapValues { (key, formControlData) ->
            formGroup.getControl(key)?.formControlValidators = formControlData.formControlValidators
            formGroup.getControl(key)?.labelResource = formControlData.labelResource
        }
        formGroup.formGroupValidators = this.formGroupValidators

        return formGroup
    }

}