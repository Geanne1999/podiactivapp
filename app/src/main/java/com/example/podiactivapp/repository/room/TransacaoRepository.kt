package br.uea.transirie.mypay.mycoffee.repository.room

import androidx.lifecycle.LiveData
import br.uea.transirie.mypay.mycoffee.enums.TipoTransacao
import br.uea.transirie.mypay.mycoffee.model.Transacao
import br.uea.transirie.mypay.mycoffee.repository.TransacaoDataSource


/**
 *  Repository de Transacao
 *  @param database Referencia à instancia do banco de dados
 * */
class TransacaoRepository(database: AppDatabase): TransacaoDataSource {

    private val transacaoDao = database.transacaoDao()

    override fun getTransacaoById(id: Long): LiveData<Transacao> {
        return transacaoDao.getTransacaoById(id)
    }

    override fun getTodasTransacoes(): LiveData<List<Transacao>> {
        return transacaoDao.getTodasTransacoes()
    }

    override fun getTodasTransacoesByUsuario(idUsuario: Long): LiveData<List<Transacao>> {
        return transacaoDao.getTodasTransacoesByUsuario(idUsuario)
    }

    override fun getDespesas(userId: Long): LiveData<List<Transacao>> {
        return transacaoDao.getDespesas(userId)
    }

    override fun getAdicoes(userId: Long): LiveData<List<Transacao>> {
        return transacaoDao.getAdicoes(userId)
    }

    override fun getTransacoesByTipo(userId: Long, tipo: TipoTransacao): LiveData<List<Transacao>> {
        return transacaoDao.getTransacoesByTipo(userId, tipo)
    }

    override fun getAllTransacoes(): List<Transacao> {
        return transacaoDao.getAllTransacoes()
    }
    override fun save(obj: Transacao): Long {
        return if (obj.id == 0L){
            insert(obj)
        }else{
            update(obj)
            obj.id
        }
    }

    override fun insert(obj: Transacao): Long {
        return transacaoDao.insert(obj)
    }

    override fun update(obj: Transacao) {
        transacaoDao.update(obj)
    }

    override fun delete(obj: Transacao) {
        transacaoDao.delete(obj)
    }
}