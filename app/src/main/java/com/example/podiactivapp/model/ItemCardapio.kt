package br.uea.transirie.mypay.mycoffee.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import br.uea.transirie.mypay.mycoffee.enums.Categoria
import br.uea.transirie.mypay.mycoffee.repository.sqlite.*

@Entity(tableName = TABLE_ITEM_CARDAPIO)
data class ItemCardapio(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ITEM_CARDAPIO_ID) var idItemCardapio: Long = 0,
    @ColumnInfo(name = COLUMN_ESTABELECIMENTO_ID) var idEstabelecimento: Long = 0,
    @ColumnInfo(name = COLUMN_ITEM_CARDAPIO_NOME) var nome: String = "",
    @ColumnInfo(name = COLUMN_ITEM_CARDAPIO_PRECO) var preco: Double = 0.0,
    @ColumnInfo(name = COLUMN_ITEM_CARDAPIO_CATEGRIA) var categoria: Categoria = Categoria.Outros
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readLong(),
        parcel.readString().toString(),
        parcel.readDouble(),
        Categoria.from(parcel.readString().toString())
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(idItemCardapio)
        parcel.writeLong(idEstabelecimento)
        parcel.writeString(nome)
        parcel.writeDouble(preco)
        parcel.writeString(categoria.nomeCategoria())
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ItemCardapio> {
        override fun createFromParcel(parcel: Parcel): ItemCardapio {
            return ItemCardapio(parcel)
        }

        override fun newArray(size: Int): Array<ItemCardapio?> {
            return arrayOfNulls(size)
        }
    }
}