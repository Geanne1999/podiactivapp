package br.uea.transirie.mypay.mycoffee.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import br.uea.transirie.mypay.mycoffee.repository.sqlite.*
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = TABLE_PRODUTO_DO_CARDAPIO)
data class ProdutoDoCardapio(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_PRODUTO_DO_CARDAPIO_ID) var id:Long = 0,
    @ColumnInfo(name = COLUMN_PRODUTO_ID) var idProduto:Long = 0,
    @ColumnInfo(name = COLUMN_ITEM_CARDAPIO_ID) var idItemCardapio:Long = 0
    //@ColumnInfo(name = COLUMN_ESTABELECIMENTO_ID) var idEstabelecimento:Long = 0,
): Parcelable{
}