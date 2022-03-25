package br.uea.transirie.mypay.mycoffee.repository.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import br.uea.transirie.mypay.mycoffee.model.ClienteListaEspera
import br.uea.transirie.mypay.mycoffee.model.Produto
import br.uea.transirie.mypay.mycoffee.model.Transacao
import br.uea.transirie.mypay.mycoffee.repository.sqlite.COLUMN_ESTABELECIMENTO_ID
import br.uea.transirie.mypay.mycoffee.repository.sqlite.TABLE_CLIENTE_LISTA_ESPERA
import br.uea.transirie.mypay.mycoffee.repository.sqlite.TABLE_PRODUTO
import br.uea.transirie.mypay.mycoffee.repository.sqlite.TABLE_TRANSACAO

@Dao
interface ClienteListaEsperaDao: BaseDao<ClienteListaEspera> {
    @Query("SELECT * FROM $TABLE_CLIENTE_LISTA_ESPERA")
    fun getAll(): LiveData<List<ClienteListaEspera>>

    @Query("select * from $TABLE_CLIENTE_LISTA_ESPERA Where $COLUMN_ESTABELECIMENTO_ID = :idUsuario")
    fun getTodosClientesByUsuario(idUsuario: Long): LiveData<List<ClienteListaEspera>>
}