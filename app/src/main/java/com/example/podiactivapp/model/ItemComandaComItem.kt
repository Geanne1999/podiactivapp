package br.uea.transirie.mypay.mycoffee.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Relation
import br.uea.transirie.mypay.mycoffee.repository.sqlite.COLUMN_ITEM_CARDAPIO_ID
import br.uea.transirie.mypay.mycoffee.repository.sqlite.COLUMN_ITEM_COMANDA_ID

data class ItemComandaComItem(
    @Embedded var itemComanda: ItemComanda,
    @Relation(
        parentColumn = COLUMN_ITEM_CARDAPIO_ID,
        entityColumn = COLUMN_ITEM_CARDAPIO_ID)
    var itemCardapio: ItemCardapio
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readParcelable(ItemComanda::class.java.classLoader)!!,
        parcel.readParcelable(ItemCardapio::class.java.classLoader)!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(itemComanda, flags)
        parcel.writeParcelable(itemCardapio, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ItemComandaComItem> {
        override fun createFromParcel(parcel: Parcel): ItemComandaComItem {
            return ItemComandaComItem(parcel)
        }

        override fun newArray(size: Int): Array<ItemComandaComItem?> {
            return arrayOfNulls(size)
        }
    }
}