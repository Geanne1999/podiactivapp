package br.uea.transirie.mypay.mycoffee.repository

import androidx.lifecycle.LiveData
import br.uea.transirie.mypay.mycoffee.enums.TipoTransacao
import br.uea.transirie.mypay.mycoffee.model.Transacao

/**
 *  Datasource para Transacao
 * */
interface TransacaoDataSource : BaseDataSource<Transacao> {

    /**
     *  Busca uma transação no banco de dados pelo seu id.
     *  @param id O id da transação a ser procurada no banco.
     *  @return Uma transação compativel com o id fornecido.
     * */
    fun getTransacaoById(id: Long): LiveData<Transacao>

    /**
     *  Busca todos as transações salvas no banco.
     *  @return Uma lista de transações encontradas no banco.
     * */
    fun getTodasTransacoes(): LiveData<List<Transacao>>

    /**
     *  Busca todas as transações salvas no banco, compativeis com o id de usuário fornecido.
     *  @param idUsuario O id do usuário que registrou as transações.
     *  @return Uma lista de transações encontradas no banco.
     * */
    fun getTodasTransacoesByUsuario(idUsuario: Long): LiveData<List<Transacao>>

    /**
     *  Busca todas as transações salvas no banco do tipo Despesa, compativeis com o id de usuário fornecido.
     *  @param idUsuario O id do usuário que registrou as transações.
     *  @return Uma lista de transações encontradas no banco.
     * */
    fun getDespesas(idUsuario: Long): LiveData<List<Transacao>>

    /**
     *  Busca todas as transações salvas no banco do tipo Adicao, compativeis com o id de usuário fornecido.
     *  @param idUsuario O id do usuário que registrou as transações.
     *  @return Uma lista de transações encontradas no banco.
     * */
    fun getAdicoes(idUsuario: Long): LiveData<List<Transacao>>

    /**
     *  Busca todas as transações salvas no banco do tipo especificado pelo usuario, compativeis com o id de usuário fornecido.
     *  @param idUsuario O id do usuário que registrou as transações.
     *  @param tipo O tipo da transação
     *  @return Uma lista de transações encontradas no banco.
     * */
    fun getTransacoesByTipo(idUsuario: Long, tipo: TipoTransacao): LiveData<List<Transacao>>

    fun getAllTransacoes():List<Transacao>
}