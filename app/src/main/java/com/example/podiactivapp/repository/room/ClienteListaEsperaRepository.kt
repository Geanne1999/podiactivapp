package br.uea.transirie.mypay.mycoffee.repository.room

import androidx.lifecycle.LiveData
import br.uea.transirie.mypay.mycoffee.model.ClienteListaEspera
import br.uea.transirie.mypay.mycoffee.model.Mesa
import br.uea.transirie.mypay.mycoffee.model.Produto
import br.uea.transirie.mypay.mycoffee.repository.ClienteListaEsperaDataSource

class ClienteListaEsperaRepository(database: AppDatabase): ClienteListaEsperaDataSource {
    private val clienteListaEsperaDao = database.clienteListaEsperaDao()

    override fun save(obj: ClienteListaEspera): Long {
        return if (obj.id == 0L){
            insert(obj)
        }else{
            update(obj)
            obj.id
        }
    }
    fun getAll(): LiveData<List<ClienteListaEspera>> {
        return clienteListaEsperaDao.getAll()
    }

    override fun getTodosClientesByUsuario(idUsuario: Long): LiveData<List<ClienteListaEspera>> {
        return clienteListaEsperaDao.getTodosClientesByUsuario(idUsuario)
    }

    override fun insert(obj: ClienteListaEspera): Long {
        return clienteListaEsperaDao.insert(obj)
    }

    override fun update(obj: ClienteListaEspera) {
        return clienteListaEsperaDao.update(obj)
    }

    override fun delete(obj: ClienteListaEspera) {
        return clienteListaEsperaDao.delete(obj)
    }
}