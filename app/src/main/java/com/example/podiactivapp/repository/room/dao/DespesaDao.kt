package br.uea.transirie.mypay.mycoffee.repository.room.dao

import androidx.room.Dao
import androidx.room.Query
import br.uea.transirie.mypay.mycoffee.model.Despesa
import br.uea.transirie.mypay.mycoffee.repository.sqlite.TABLE_DESPESA

@Dao
interface DespesaDao: BaseDao<Despesa> {

    @Query("""SELECT * FROM $TABLE_DESPESA""")
    fun getAllDespesa(): List<Despesa>
}