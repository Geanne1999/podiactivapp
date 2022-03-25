package br.uea.transirie.mypay.mycoffee.repository.room

import br.uea.transirie.mypay.mycoffee.model.Payment
import br.uea.transirie.mypay.mycoffee.repository.PaymentDataSource

class PaymentRepository(database: AppDatabase): PaymentDataSource {
    private val pagamentoDao = database.pagamentoDao()

    override fun save(obj: Payment) : Long {
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


    override fun insert(obj: Payment): Long {
        return pagamentoDao.insert(obj)
    }

    override fun update(obj: Payment) {
        return pagamentoDao.update(obj)
    }

    override fun delete(obj: Payment) {
        return pagamentoDao.delete(obj)
    }

    override fun getAllPagamentos(): List<Payment> {
        return pagamentoDao.getAllPagamentos()
    }
}