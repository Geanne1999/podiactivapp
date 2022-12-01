package br.uea.transirie.mypay.mycoffee.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import br.uea.transirie.mypay.mycoffee.repository.sqlite.COLUMN_ANSWER
import br.uea.transirie.mypay.mycoffee.repository.sqlite.COLUMN_QUESTION
import br.uea.transirie.mypay.mycoffee.repository.sqlite.TABLE_QUESTION

@Entity(tableName = TABLE_QUESTION)
class Question(
    @ColumnInfo(name = COLUMN_QUESTION) var question: String = "",
    @ColumnInfo(name = COLUMN_ANSWER) var answer:String = ""
){

}