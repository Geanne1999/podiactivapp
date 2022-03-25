package br.uea.transirie.mypay.mycoffee.repository.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import br.uea.transirie.mypay.mycoffee.model.ItemComanda
import br.uea.transirie.mypay.mycoffee.model.ItemComandaComItem
import br.uea.transirie.mypay.mycoffee.repository.sqlite.COLUMN_COMANDA_ID
import br.uea.transirie.mypay.mycoffee.repository.sqlite.COLUMN_ITEM_COMANDA_ID
import br.uea.transirie.mypay.mycoffee.repository.sqlite.TABLE_ITEM_COMANDA

@Dao
interface ItemComandaDao:BaseDao<ItemComanda> {

    @Query("select * from $TABLE_ITEM_COMANDA where $COLUMN_ITEM_COMANDA_ID = :id")
    fun itemComandaByID(id: Long): LiveData<ItemComanda>

    @Query("select * from $TABLE_ITEM_COMANDA where $COLUMN_COMANDA_ID = :comandaId")
    fun itensComandaByComanda(comandaId: Long): LiveData<List<ItemComanda>>

    @Transaction
    @Query("select * from $TABLE_ITEM_COMANDA where $COLUMN_COMANDA_ID = :comandaId")
    fun getListaItensComandaComItem(comandaId: Long): LiveData<List<ItemComandaComItem>>
}