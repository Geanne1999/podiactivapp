package br.uea.transirie.mypay.mycoffee.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import br.uea.transirie.mypay.mycoffee.repository.sqlite.COLUMN_PERGUNTA
import br.uea.transirie.mypay.mycoffee.repository.sqlite.COLUMN_RESPOSTA
import br.uea.transirie.mypay.mycoffee.repository.sqlite.TABLE_PERGUNTA

@Entity(tableName = TABLE_PERGUNTA)
class Pergunta(
    @ColumnInfo(name = COLUMN_PERGUNTA) var pergunta: String = "",
    @ColumnInfo(name = COLUMN_RESPOSTA) var resposta:String = ""
){

}