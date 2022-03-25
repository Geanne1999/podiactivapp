package br.uea.transirie.mypay.mycoffee.repository

import androidx.lifecycle.LiveData
import br.uea.transirie.mypay.mycoffee.model.ItemComanda
import br.uea.transirie.mypay.mycoffee.model.ItemComandaComItem

interface ItemComandaDataSource:BaseDataSource<ItemComanda> {
    fun itemComandaByID(id: Long): LiveData<ItemComanda>
    fun itensComandaByComanda(comandaId: Long): LiveData<List<ItemComanda>>
    fun getListaItensComandaComItem(comandaId: Long): LiveData<List<ItemComandaComItem>>
}