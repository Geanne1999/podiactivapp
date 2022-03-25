package br.uea.transirie.mypay.mycoffee.repository.room

import androidx.lifecycle.LiveData
import br.uea.transirie.mypay.mycoffee.model.Mesa
import br.uea.transirie.mypay.mycoffee.repository.MesaDataSource

class MesaRepository(database: AppDatabase): MesaDataSource {
    private val mesaDao = database.mesaDao()

    override fun getObserverAllMesas(idEstabelecimento: Long): LiveData<List<Mesa>> {
        return mesaDao.getObserverAllMesas(idEstabelecimento)
    }

    override fun getAllMesas(idEstabelecimento: Long): List<Mesa> {
        return mesaDao.getAllMesas(idEstabelecimento)
    }

    override fun getMesaById(idMesa: Long): LiveData<Mesa> {
        return mesaDao.getMesaById(idMesa)
    }

    override fun save(obj: Mesa): Long {
        return if (obj.idMesa == 0L){
            insert(obj)
        }else{
            update(obj)
            obj.idMesa
        }
    }

    override fun insert(obj: Mesa): Long {
       return mesaDao.insert(obj)
    }

    override fun update(obj: Mesa) {
        return mesaDao.update(obj)
    }

    override fun delete(obj: Mesa) {
        return mesaDao.delete(obj)
    }
}