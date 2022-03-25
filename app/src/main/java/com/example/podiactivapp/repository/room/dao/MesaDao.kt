package br.uea.transirie.mypay.mycoffee.repository.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import br.uea.transirie.mypay.mycoffee.enums.StatusMesa
import br.uea.transirie.mypay.mycoffee.model.Mesa
import br.uea.transirie.mypay.mycoffee.repository.sqlite.*

@Dao
interface MesaDao: BaseDao<Mesa> {
    @Query("""SELECT * FROM $TABLE_MESA WHERE $COLUMN_ESTABELECIMENTO_ID = :idEstabelecimento""")
    fun getObserverAllMesas(idEstabelecimento: Long): LiveData<List<Mesa>>

    @Query("""SELECT * FROM $TABLE_MESA WHERE $COLUMN_ESTABELECIMENTO_ID = :idEstabelecimento""")
    fun getAllMesas(idEstabelecimento: Long): List<Mesa>

    @Query("""SELECT * FROM $TABLE_MESA WHERE $COLUMN_MESA_ID = :idMesa""")
    fun getMesaById(idMesa: Long): LiveData<Mesa>
}
