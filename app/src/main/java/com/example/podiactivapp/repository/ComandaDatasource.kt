package br.uea.transirie.mypay.mycoffee.repository

import androidx.lifecycle.LiveData
import br.uea.transirie.mypay.mycoffee.model.Comanda
import br.uea.transirie.mypay.mycoffee.model.ComandaComItens
import java.time.LocalDate

interface ComandaDatasource:BaseDataSource<Comanda> {
    fun comandaByID(id: Long): LiveData<Comanda>
    fun getComandasByEstabelecimento(idEstabelecimento: Long): LiveData<List<Comanda>>
    fun getComandasAtiva(idEstabelecimento: Long): LiveData<List<Comanda>>
    fun getComandasFinalizada(idEstabelecimento: Long): LiveData<List<Comanda>>
    fun getComandasByData(idEstabelecimento: Long, date: LocalDate): LiveData<List<Comanda>>
    fun getComandasByDataAndMesa(idEstabelecimento: Long, date: LocalDate, mesa: Long): LiveData<List<Comanda>>
    fun getComandasMesa(idEstabelecimento: Long, mesa: Long): LiveData<List<Comanda>>
    fun getComandasAtivasByMesa(idEstabelecimento: Long, idMesa: Long): LiveData<List<Comanda>>
}