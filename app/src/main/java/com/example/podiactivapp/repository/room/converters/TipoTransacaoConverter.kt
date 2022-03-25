package br.uea.transirie.mypay.mycoffee.repository.room.converters

import androidx.room.TypeConverter
import br.uea.transirie.mypay.mycoffee.enums.TipoTransacao

class TipoTransacaoConverter {
    @TypeConverter
    fun fromTipoTransacao(tipoTransacao: TipoTransacao): String {
        return tipoTransacao.toString()
    }

    @TypeConverter
    fun toTipoTransacao(strTipoTransacao: String): TipoTransacao {
        return TipoTransacao.valueOf(strTipoTransacao)
    }
}