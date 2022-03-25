package br.uea.transirie.mypay.mycoffee.repository.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import br.uea.transirie.mypay.mycoffee.enums.TipoTransacao
import br.uea.transirie.mypay.mycoffee.model.Transacao
import br.uea.transirie.mypay.mycoffee.repository.sqlite.*


@Dao
interface TransacaoDao : BaseDao<Transacao> {

    /**
     *  Busca uma transação no banco de dados pelo seu id.
     *  @param id O id da transação a ser procurada no banco.
     *  @return Uma transação compativel com o id fornecido.
     * */
    @Query("select * from $TABLE_TRANSACAO where $COLUMN_TRANSACAO_ID = :id")
    fun getTransacaoById(id: Long): LiveData<Transacao>

    /**
     *  Busca todos as transações salvas no banco.
     *  @return Uma lista de transações encontradas no banco.
     * */
    @Query("select * from $TABLE_TRANSACAO")
    fun getTodasTransacoes(): LiveData<List<Transacao>>

    /**
     *  Busca todas as transações salvas no banco, compativeis com o id de usuário fornecido.
     *  @param idUsuario O id do usuário que registrou as transações.
     *  @return Uma lista de transações encontradas no banco.
     * */
    @Query("select * from $TABLE_TRANSACAO where $COLUMN_ESTABELECIMENTO_ID = :idUsuario")
    fun getTodasTransacoesByUsuario(idUsuario: Long): LiveData<List<Transacao>>

    /**
     *  Busca todas as transações salvas no banco do tipo Despesa, compativeis com o id de usuário fornecido.
     *  @param idUsuario O id do usuário que registrou as transações.
     *  @return Uma lista de transações encontradas no banco.
     * */
    @Query("select * from $TABLE_TRANSACAO where $COLUMN_ESTABELECIMENTO_ID = :idUsuario and $COLUMN_TRANSACAO_DESPESA")
    fun getDespesas(idUsuario: Long): LiveData<List<Transacao>>

    /**
     *  Busca todas as transações salvas no banco do tipo Adicao, compativeis com o id de usuário fornecido.
     *  @param idUsuario O id do usuário que registrou as transações.
     *  @return Uma lista de transações encontradas no banco.
     * */
    @Query("select * from $TABLE_TRANSACAO where $COLUMN_ESTABELECIMENTO_ID = :idUsuario and not $COLUMN_TRANSACAO_DESPESA")
    fun getAdicoes(idUsuario: Long): LiveData<List<Transacao>>

    /**
     *  Busca todas as transações salvas no banco do tipo especificado pelo usuario, compativeis com o id de usuário fornecido.
     *  @param idUsuario O id do usuário que registrou as transações.
     *  @param tipo O tipo da transação
     *  @return Uma lista de transações encontradas no banco.
     * */
    @Query("select * from $TABLE_TRANSACAO where $COLUMN_ESTABELECIMENTO_ID = :idUsuario and $COLUMN_TRANSACAO_TIPO = :tipo")
    fun getTransacoesByTipo(idUsuario: Long, tipo: TipoTransacao): LiveData<List<Transacao>>

    @Query("select * from $TABLE_TRANSACAO")
    fun getAllTransacoes(): List<Transacao>

}