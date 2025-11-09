package pe.devs.kmp.formvalidations.composableUtils

import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.stringArrayResource
import org.jetbrains.compose.resources.stringResource
import pe.devs.kmp.formvalidations.formvalidations.generated.resources.Res
import pe.devs.kmp.formvalidations.formvalidations.generated.resources.label_formatted_date
import pe.devs.kmp.formvalidations.formvalidations.generated.resources.label_formatted_datetime
import pe.devs.kmp.formvalidations.formvalidations.generated.resources.label_months
import pe.devs.kmp.formvalidations.util.TimeUtil

object ComposableDateUtil {

    @Composable
    fun formatDate(millis: Long?, zoneId: String): String {
        if (millis == null) return ""

        val months = stringArrayResource(Res.array.label_months)

        val dt = TimeUtil.parseUtcMillisToLocalDateTime(millis, zoneId)

        val monthIndex = dt.date.monthNumber - 1 // Mes 1 = enero → índice 0
        val monthName = months.getOrNull(monthIndex) ?: ""


        return stringResource(
            Res.string.label_formatted_date,
            dt.date.dayOfMonth.toString(),
            monthName,
            dt.date.year.toString()
        )
    }

    @Composable
    fun formatDateTime(millis: Long?, zoneId: String): String {
        if (millis == null) return ""

        val months = stringArrayResource(Res.array.label_months)

        val dt = TimeUtil.parseUtcMillisToLocalDateTime(millis, zoneId)

        val monthIndex = dt.date.monthNumber - 1 // Mes 1 = enero → índice 0
        val monthName = months.getOrNull(monthIndex) ?: ""

        val hour = dt.hour % 12
        val hour12 = if (hour == 0) 12 else hour
        val minute = dt.minute.toString().padStart(2, '0')
        val amPm = if (dt.hour < 12) "AM" else "PM"

        return stringResource(
            Res.string.label_formatted_datetime,
            dt.date.dayOfMonth.toString(),
            monthName,
            dt.date.year.toString(),
            hour12.toString(),
            minute,
            amPm
        )
    }
}