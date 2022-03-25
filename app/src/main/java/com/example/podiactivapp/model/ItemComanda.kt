package br.uea.transirie.mypay.mycoffee.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import br.uea.transirie.mypay.mycoffee.repository.sqlite.*

@Entity(tableName = TABLE_ITEM_COMANDA)
data class ItemComanda(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ITEM_COMANDA_ID) var itemComandaId: Long = 0,
    @ColumnInfo(name = COLUMN_ITEM_CARDAPIO_ID) var itemCardapioId: Long = 0,
    @ColumnInfo(name = COLUMN_COMANDA_ID) var comandaId: Long = 0,
    @ColumnInfo(name = COLUMN_ITEM_COMANDA_QUANIDADE) var quantidade: Int = 0,
    @ColumnInfo(name = COLUMN_ITEM_COMANDA_OBSERVACOES) var observacoes: String = ""
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readLong(),
        parcel.readLong(),
        parcel.readInt(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(itemComandaId)
        parcel.writeLong(itemCardapioId)
        parcel.writeLong(comandaId)
        parcel.writeInt(quantidade)
        parcel.writeString(observacoes)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ItemComanda> {
        override fun createFromParcel(parcel: Parcel): ItemComanda {
            return ItemComanda(parcel)
        }

        override fun newArray(size: Int): Array<ItemComanda?> {
            return arrayOfNulls(size)
        }
    }

}