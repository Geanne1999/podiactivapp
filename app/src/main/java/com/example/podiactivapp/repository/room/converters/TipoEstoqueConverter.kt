package br.uea.transirie.mypay.mycoffee.repository.room.converters

import androidx.room.TypeConverter
import br.uea.transirie.mypay.mycoffee.enums.Estoque

class TipoEstoqueConverter {
    @TypeConverter
    fun fromEstoque(Estoque: Estoque): String {
        return Estoque.name
    }

    @TypeConverter
    fun toEstoque(strEstoque: String): Estoque {
        return Estoque.valueOf(strEstoque)
    }
}