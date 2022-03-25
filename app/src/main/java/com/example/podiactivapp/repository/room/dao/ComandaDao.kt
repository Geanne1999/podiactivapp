package br.uea.transirie.mypay.mycoffee.repository.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import br.uea.transirie.mypay.mycoffee.model.Comanda
import br.uea.transirie.mypay.mycoffee.model.ComandaComItens
import br.uea.transirie.mypay.mycoffee.repository.sqlite.*
import java.time.LocalDate

@Dao
interface ComandaDao : BaseDao<Comanda> {
    @Query("select * from $TABLE_COMANDA where $COLUMN_COMANDA_ID = :id")
    fun comandaByID(id: Long): LiveData<Comanda>

    @Query("select * from $TABLE_COMANDA where $COLUMN_ESTABELECIMENTO_ID = :idEstabelecimento")
    fun getComandasByEstabelecimento(idEstabelecimento: Long): LiveData<List<Comanda>>

    @Query("select * from $TABLE_COMANDA where $COLUMN_ESTABELECIMENTO_ID = :idEstabelecimento and $COLUMN_COMANDA_ATIVA")
    fun getComandasAtiva(idEstabelecimento: Long): LiveData<List<Comanda>>

    @Query("select * from $TABLE_COMANDA where $COLUMN_ESTABELECIMENTO_ID = :idEstabelecimento and not $COLUMN_COMANDA_ATIVA")
    fun getComandasFinalizada(idEstabelecimento: Long): LiveData<List<Comanda>>

    @Query("select * from $TABLE_COMANDA where $COLUMN_ESTABELECIMENTO_ID = :idEstabelecimento and $COLUMN_COMANDA_DATE = :date")
    fun getComandasByData(idEstabelecimento: Long, date: LocalDate): LiveData<List<Comanda>>

    @Query("select * from $TABLE_COMANDA where $COLUMN_ESTABELECIMENTO_ID = :idEstabelecimento and $COLUMN_COMANDA_DATE = :date and $COLUMN_MESA_ID = :mesa")
    fun getComandasByDataAndMesa(idEstabelecimento: Long, date: LocalDate, mesa: Long): LiveData<List<Comanda>>

    @Query("select * from $TABLE_COMANDA where $COLUMN_ESTABELECIMENTO_ID = :idEstabelecimento and $COLUMN_MESA_ID = :mesa")
    fun getComandasMesa(idEstabelecimento: Long, mesa: Long): LiveData<List<Comanda>>

    @Query("select * from $TABLE_COMANDA where $COLUMN_MESA_ID = :idMesa and $COLUMN_ESTABELECIMENTO_ID = :idEstabelecimento and $COLUMN_COMANDA_ATIVA")
    fun getComandasAtivasByMesa(idEstabelecimento: Long, idMesa: Long): LiveData<List<Comanda>>

}