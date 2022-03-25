package br.uea.transirie.mypay.mycoffee.repository.room

import br.uea.transirie.mypay.mycoffee.model.Despesa
import br.uea.transirie.mypay.mycoffee.repository.DespesaDataSource

class DespesaRepository(database: AppDatabase): DespesaDataSource {
    private val despesaDao = database.despesaDao()

    override fun getAllDespesa(): List<Despesa> {
        return despesaDao.getAllDespesa()
    }

    override fun save(obj: Despesa) : Long {
        // se id == 0 significa que foi instanciado com o valor padrão
        return if (obj.id == 0L) {
            val id = insert(obj)
            obj.id = id
            id
        } else {
            update(obj)
            obj.id
        }
    }

    override fun delete(obj: Despesa) {
        return despesaDao.delete(obj)
    }

    override fun insert(obj: Despesa): Long {
        return despesaDao.insert(obj)
    }

    override fun update(obj: Despesa) {
        return despesaDao.update(obj)
    }
}