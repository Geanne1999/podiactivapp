package br.uea.transirie.mypay.mypaytemplate.repository.room.converters

import androidx.room.TypeConverter
import java.time.LocalDate

class LocalDateConverter {
    @TypeConverter
    fun fromLocalDate(localdate: LocalDate): String {
        return localdate.toString()
    }

    @TypeConverter
    fun toLocalDate(strLocalDate: String): LocalDate {
        return LocalDate.parse(strLocalDate)
    }
}