package br.uea.transirie.mypay.mycoffee.repository.room

import androidx.lifecycle.LiveData
import br.uea.transirie.mypay.mycoffee.model.ItemComanda
import br.uea.transirie.mypay.mycoffee.model.ItemComandaComItem
import br.uea.transirie.mypay.mycoffee.repository.ItemComandaDataSource

class ItemComandaRepository(appDatabase: AppDatabase):ItemComandaDataSource {

    private val dao = appDatabase.itemComandaDao()

    override fun itemComandaByID(id: Long): LiveData<ItemComanda> {
        return dao.itemComandaByID(id)
    }

    override fun itensComandaByComanda(comandaId: Long): LiveData<List<ItemComanda>> {
        return dao.itensComandaByComanda(comandaId)
    }

    override fun getListaItensComandaComItem(comandaId: Long): LiveData<List<ItemComandaComItem>> {
        return dao.getListaItensComandaComItem(comandaId)
    }

    override fun save(obj: ItemComanda): Long {
        return if(obj.itemComandaId == 0L) insert(obj)
        else{
            update(obj)
            obj.itemComandaId
        }
    }

    override fun insert(obj: ItemComanda): Long {
        return dao.insert(obj)
    }

    override fun update(obj: ItemComanda) {
        dao.update(obj)
    }

    override fun delete(obj: ItemComanda) {
        dao.delete(obj)
    }
}