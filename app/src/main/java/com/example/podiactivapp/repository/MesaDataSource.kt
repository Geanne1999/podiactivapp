package br.uea.transirie.mypay.mycoffee.repository

import androidx.lifecycle.LiveData
import br.uea.transirie.mypay.mycoffee.model.Mesa

interface MesaDataSource: BaseDataSource<Mesa> {
    fun getObserverAllMesas(idEstabelecimento: Long): LiveData<List<Mesa>>
    fun getAllMesas(idEstabelecimento: Long): List<Mesa>
    fun getMesaById(idMesa: Long): LiveData<Mesa>
}
