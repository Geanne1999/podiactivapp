package br.uea.transirie.mypay.mycoffee.repository.room

import androidx.lifecycle.LiveData
import br.uea.transirie.mypay.mycoffee.model.Comanda
import br.uea.transirie.mypay.mycoffee.model.ComandaComItens
import br.uea.transirie.mypay.mycoffee.repository.ComandaDatasource
import java.time.LocalDate

class ComandaRepository(database: AppDatabase) : ComandaDatasource {

    private val dao = database.comandaDao()

    override fun comandaByID(id: Long): LiveData<Comanda> {
        return dao.comandaByID(id)
    }

    override fun getComandasByEstabelecimento(idEstabelecimento: Long): LiveData<List<Comanda>> {
        return dao.getComandasByEstabelecimento(idEstabelecimento)
    }

    override fun getComandasAtiva(idEstabelecimento: Long): LiveData<List<Comanda>> {
        return dao.getComandasAtiva(idEstabelecimento)
    }

    override fun getComandasFinalizada(idEstabelecimento: Long): LiveData<List<Comanda>> {
        return dao.getComandasFinalizada(idEstabelecimento)
    }

    override fun getComandasByData(
        idEstabelecimento: Long,
        date: LocalDate
    ): LiveData<List<Comanda>> {
        return dao.getComandasByData(idEstabelecimento, date)
    }

    override fun getComandasByDataAndMesa(
        idEstabelecimento: Long,
        date: LocalDate,
        mesa: Long
    ): LiveData<List<Comanda>> {
        return dao.getComandasByDataAndMesa(idEstabelecimento, date, mesa)
    }

    override fun getComandasMesa(
        idEstabelecimento: Long,
        mesa: Long
    ): LiveData<List<Comanda>> {
        return dao.getComandasMesa(idEstabelecimento, mesa)
    }

    override fun getComandasAtivasByMesa(
        idEstabelecimento: Long,
        idMesa: Long
    ): LiveData<List<Comanda>> {
        return dao.getComandasAtivasByMesa(idEstabelecimento, idMesa)
    }


    override fun save(obj: Comanda): Long {
        return if (obj.comandaID == 0L)
            dao.insert(obj)
        else {
            dao.update(obj)
            obj.comandaID
        }
    }

    override fun insert(obj: Comanda): Long {
        return dao.insert(obj)
    }

    override fun update(obj: Comanda) {
        return dao.update(obj)
    }

    override fun delete(obj: Comanda) {
        return dao.delete(obj)
    }
}