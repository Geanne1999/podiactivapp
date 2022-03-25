package br.uea.transirie.mypay.mycoffee.repository

import androidx.lifecycle.LiveData
import br.uea.transirie.mypay.mycoffee.model.ClienteListaEspera

interface ClienteListaEsperaDataSource : BaseDataSource<ClienteListaEspera>{
    fun getTodosClientesByUsuario(idUsuario: Long): LiveData<List<ClienteListaEspera>>
}