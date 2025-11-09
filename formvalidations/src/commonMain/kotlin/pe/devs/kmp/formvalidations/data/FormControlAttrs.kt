package pe.devs.kmp.formvalidations.data

import org.jetbrains.compose.resources.StringResource
import pe.devs.kmp.formvalidations.validation.abstracts.FormControlValidator

class FormControlAttrs(
    val labelResource: StringResource,
    val formControlValidators: List<FormControlValidator>,
    val initialValue: String = ""
)