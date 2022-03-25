package br.uea.transirie.mypay.mycoffee.repository.room.converters

import androidx.room.TypeConverter
import br.uea.transirie.mypay.mycoffee.enums.Categoria

class CategoriaConverter {
    @TypeConverter
    fun fromCategoria(categoria: Categoria): String {
        return categoria.nomeCategoria()
    }

    @TypeConverter
    fun toCategoria(strCategoria: String): Categoria {
        return Categoria.from(strCategoria)
    }
}
