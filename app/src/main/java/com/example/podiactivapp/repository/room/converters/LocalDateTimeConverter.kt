package br.uea.transirie.mypay.mypaytemplate.repository.room.converters

import androidx.room.TypeConverter
import java.time.LocalDateTime

class LocalDateTimeConverter {
    @TypeConverter
    fun fromLocalDateTime(localdate: LocalDateTime): String {
        return localdate.toString()
    }

    @TypeConverter
    fun toLocalDateTime(strLocalDateTime: String): LocalDateTime {
        return LocalDateTime.parse(strLocalDateTime)
    }
}