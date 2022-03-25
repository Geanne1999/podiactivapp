package br.uea.transirie.mypay.mycoffee.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import br.uea.transirie.mypay.mycoffee.repository.sqlite.*
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = TABLE_CLIENTE_LISTA_ESPERA)
data class ClienteListaEspera(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID) var id: Long = 0,
    @ColumnInfo(name = COLUMN_ESTABELECIMENTO_ID) var idEstab:Long=0,
    @ColumnInfo(name = COLUMN_NOME_CLIENTE_LISTA_ESPERA) var nomeClienteListaEspera: String = "",
    @ColumnInfo(name = COLUMN_QUANTIDADE_LISTA_ESPERA) var quantPessoas: Int =0
):Parcelable{
}