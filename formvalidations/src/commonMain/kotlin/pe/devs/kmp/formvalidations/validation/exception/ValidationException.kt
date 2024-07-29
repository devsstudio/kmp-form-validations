package pe.devs.kmp.formvalidations.validation.exception

import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

class ValidationException(
    override val message: String,
    private vararg val args: Any = emptyArray()
) : Exception(message) {

    private var resourceKey: StringResource? = null

    constructor(resourceKey: StringResource, vararg args: Any = emptyArray()) : this(
        "", *args
    ) {
        this.resourceKey = resourceKey
    }

    @Composable
    fun resolveMessage(): String {
        if (resourceKey != null) {
            val formatArgs = args.map { it ->
                when (it) {
                    is StringResource -> stringResource(it)
                    is String -> it
                    else -> it.toString()
                }
            }
            return stringResource(resource = resourceKey!!, *formatArgs.toTypedArray())
        } else {
            return this.message
        }

    }
}