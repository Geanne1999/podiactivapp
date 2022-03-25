package br.uea.transirie.mypay.mycoffee.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import br.uea.transirie.mypay.mycoffee.repository.sqlite.*
import kotlinx.android.parcel.Parcelize


@Entity(tableName = TABLE_PRODUTO)
@Parcelize
data class Produto(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID) var id: Long = 0,
    @ColumnInfo(name = COLUMN_ESTABELECIMENTO_ID) var idEstabelecimento: Long = 0,
    @ColumnInfo(name = COLUMN_NOME_ITEM) var nome: String = "",
    @ColumnInfo(name = COLUMN_QUANTIDADE) var quantidade:Float=0f,
    @ColumnInfo(name = COLUMN_UNIDADE_MEDIDA) var unidadeMed:String="",
    @ColumnInfo(name = COLUMN_STATUS_SERVICO) var statusServico: Boolean=true
): Parcelable{

}