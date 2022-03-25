package br.uea.transirie.mypay.mycoffee.repository.room.dao

import androidx.room.Dao
import androidx.room.Query
import br.uea.transirie.mypay.mycoffee.model.Payment
import br.uea.transirie.mypay.mycoffee.repository.sqlite.TABLE_PAGAMENTO

@Dao
interface PaymentDao: BaseDao<Payment> {



    /**
     * Obtém todos os pagamentos cadastrados
     */
    @Query("""SELECT * FROM $TABLE_PAGAMENTO""")
    fun getAllPagamentos(): List<Payment>

    /**
     * Obtém um pagamento utilizando o id
     *
     * @param id é o id do pagamento a ser buscado
     * */
 //   @Query("""SELECT * FROM $TABLE_PAGAMENTO WHERE $COLUMN_ID = :id""")
 //   fun pagamentoById(id: Long): Pagamento

}