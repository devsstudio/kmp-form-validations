package pe.devs.kmp.formvalidations.util

object AmountUtil {
    fun formatToDecimals(value: Double?, decimals: Int): String {
        if (value == null) return "0." + "0".repeat(decimals)
        val factor = 10.0.pow(decimals)
        val rounded = kotlin.math.round(value * factor) / factor
        val parts = rounded.toString().split(".")
        val integer = parts[0]
        val fraction = if (parts.size > 1) parts[1].padEnd(decimals, '0') else "0".repeat(decimals)
        return "$integer.$fraction"
    }

    // Helper extension para pow en Double (KMP compatible)
    private fun Double.pow(exp: Int): Double {
        var result = 1.0
        repeat(exp) { result *= this }
        return result
    }
}