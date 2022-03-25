package br.uea.transirie.mypay.mycoffee.repository.room.converters

import androidx.room.TypeConverter
import java.time.LocalTime

class LocalTimeConverter {
    @TypeConverter
    fun fromLocalTime(localtime: LocalTime): String {
        return localtime.toString()
    }

    @TypeConverter
    fun toLocalTime(strLocalTime: String): LocalTime {
        return LocalTime.parse(strLocalTime)
    }
}