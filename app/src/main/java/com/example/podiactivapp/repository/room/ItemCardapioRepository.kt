package br.uea.transirie.mypay.mycoffee.repository.room

import androidx.lifecycle.LiveData
import br.uea.transirie.mypay.mycoffee.enums.Categoria
import br.uea.transirie.mypay.mycoffee.model.ItemCardapio
import br.uea.transirie.mypay.mycoffee.repository.ItemCardapioDataSource

class ItemCardapioRepository(appDatabase: AppDatabase):ItemCardapioDataSource {
    private val itemCardapioDao = appDatabase.itemCardapioDao()

    override fun itemCardapioByID(id: Long): LiveData<ItemCardapio> {
        return itemCardapioDao.itemCardapioByID(id)
    }

    override fun getTodosOsItensByEstabelecimento(idEstabelecimentoDao: Long): LiveData<List<ItemCardapio>> {
        return itemCardapioDao.getTodosOsItensByEstabelecimento(idEstabelecimentoDao)
    }

    override fun getTodosOsItensByCategoria(idEstabelecimento: Long, categoria: Categoria): LiveData<List<ItemCardapio>> {
        return itemCardapioDao.getTodosOsItensByCategoria(idEstabelecimento, categoria)
    }

    override fun getCategorias(idEstabelecimento: Long): LiveData<List<Categoria>> {
        return itemCardapioDao.getCategorias(idEstabelecimento)
    }

    override fun save(obj: ItemCardapio): Long {
        return if (obj.idItemCardapio == 0L){
            insert(obj)
        }else{
            update(obj)
            obj.idItemCardapio
        }
    }

    override fun insert(obj: ItemCardapio): Long {
        return itemCardapioDao.insert(obj)
    }

    override fun update(obj: ItemCardapio) {
        itemCardapioDao.update(obj)
    }

    override fun delete(obj: ItemCardapio) {
        itemCardapioDao.delete(obj)
    }
}