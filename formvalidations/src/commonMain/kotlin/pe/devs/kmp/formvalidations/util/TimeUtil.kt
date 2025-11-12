package pe.devs.kmp.formvalidations.util

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.offsetAt
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.time.Instant


@OptIn(ExperimentalTime::class)
object TimeUtil {

    /**
     * Get the current UTC time in millis
     */
    fun getCurrentUTCMillis(): Long {
        return Clock.System.now().toEpochMilliseconds()
    }

    /**
     * Get the current local time in millis
     */
    fun getCurrentLocalMillis(zoneId: String): Long {
        val instant = Clock.System.now()
        val offsetMillis = TimeZone.of(zoneId).offsetAt(instant).totalSeconds * 1000L
        return instant.toEpochMilliseconds() + offsetMillis
    }

    /**
     * Get the current offset in limits
     */
    fun getCurrentOffset(zoneId: String): Long {
        val tz = TimeZone.of(zoneId)
        val instant = Clock.System.now()
        val offset = tz.offsetAt(instant)
        return offset.totalSeconds * 1000L
    }

    /**
     * Get the hour and minute of the current time
     */
    fun getCurrentLocalTimeTri(zoneId: String): Triple<Int, Int, Int> {
        val tz = TimeZone.of(zoneId)
        val now = Clock.System.now().toLocalDateTime(tz)
        return Triple(now.hour, now.minute, now.second)
    }

    /**
     * Get the milliseconds of the current hour and minute
     * (i.e., HH:mm:ss in milliseconds since midnight)
     */
    fun getCurrentTimeMillis(zoneId: String): Long {
        val triple = getCurrentLocalTimeTri(zoneId)
        return parseTriToMillis(triple)
    }

    fun parseTriToMillis(tiple: Triple<Int, Int, Int>): Long {
        return (tiple.first * 3600L + tiple.second * 60 + tiple.third) * 1000
    }

    /**
     * Parse a HH:mm string to hour and minute
     */
    fun parseIsoTimeToTri(time: String): Triple<Int, Int, Int>? {
        return try {
            val parts = time.split(":")
            val hour = parts[0].toInt()
            val minute = parts[1].toInt()
            val second = parts[2].toInt()
            return Triple(hour, minute, second)
        } catch (err: Exception) {
            null
        }
    }

    /**
     * Parse a HH:mm string to millis
     */
    fun parseIsoTimeToMillis(time: String): Long? {
        val tri = parseIsoTimeToTri(time)
        return if (tri != null) {
            (tri.first * 3600L + tri.second * 60 + tri.third) * 1000
        } else {
            null
        }
    }

    fun parseTriToIsoTime(pair: Triple<Int, Int, Int>): String {
        val hourFormatted = pair.first.toString().padStart(2, '0')
        val minuteFormatted = pair.second.toString().padStart(2, '0')
        val secondFormatted = pair.third.toString().padStart(2, '0')
        return "$hourFormatted:$minuteFormatted:$secondFormatted"
    }

    fun parseUtcMillisToLocalDateTime(millis: Long, zoneId: String): LocalDateTime {
        return Instant.fromEpochMilliseconds(millis).toLocalDateTime(TimeZone.of(zoneId))
    }

    fun parseUtcMillisToLocalTimeTri(millis: Long, zoneId: String): Triple<Int, Int, Int> {
        val dt = parseUtcMillisToLocalDateTime(millis, zoneId)
        return Triple(dt.hour, dt.minute, dt.second)
    }



    fun formatTo12Hour(time: String): String? {
        val tri = parseIsoTimeToTri(time)

        if (tri != null) {
            val hour12 = when {
                tri.first == 0 -> 12
                tri.first > 12 -> tri.first - 12
                else -> tri.first
            }

            val amPm = if (tri.first < 12) "AM" else "PM"

            val hourFormatted = hour12.toString().padStart(2, '0')
            val minuteFormatted = tri.second.toString().padStart(2, '0')
            val secondFormatted = tri.third.toString().padStart(2, '0')

            return "$hourFormatted:$minuteFormatted:$secondFormatted $amPm"
        } else {
            return null
        }
    }

    /**
     * Convert a UTC ISO string date to UTC millis
     */
    fun parseIsoToUtcMillis(isoUtc: String): Long? {
        return try {
            Instant.parse(isoUtc).toEpochMilliseconds()
        } catch (e: Exception) {
            null
        }
    }

    /**
     * Convert a UTC ISO string date to local millis
     */
    fun parseIsoToLocalMillis(isoUtc: String, zoneId: String): Long? {
        return try {
            val instant = Instant.parse(isoUtc)
            val offsetMillis = TimeZone.of(zoneId).offsetAt(instant).totalSeconds * 1000L
            instant.toEpochMilliseconds() + offsetMillis
        } catch (e: Exception) {
            null
        }
    }


    /**
     * Convert a millis time to UTC ISO string date
     */
    fun parseMillisToIso(utcMillis: Long): String {
        return Instant.fromEpochMilliseconds(utcMillis).toString()
    }
}