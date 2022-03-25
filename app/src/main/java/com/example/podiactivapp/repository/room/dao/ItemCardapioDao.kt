package br.uea.transirie.mypay.mycoffee.repository.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import br.uea.transirie.mypay.mycoffee.enums.Categoria
import br.uea.transirie.mypay.mycoffee.model.ItemCardapio
import br.uea.transirie.mypay.mycoffee.repository.sqlite.COLUMN_ESTABELECIMENTO_ID
import br.uea.transirie.mypay.mycoffee.repository.sqlite.COLUMN_ITEM_CARDAPIO_CATEGRIA
import br.uea.transirie.mypay.mycoffee.repository.sqlite.COLUMN_ITEM_CARDAPIO_ID
import br.uea.transirie.mypay.mycoffee.repository.sqlite.TABLE_ITEM_CARDAPIO

@Dao
interface ItemCardapioDao : BaseDao<ItemCardapio> {
    @Query("select * from $TABLE_ITEM_CARDAPIO where $COLUMN_ITEM_CARDAPIO_ID = :id")
    fun itemCardapioByID(id: Long): LiveData<ItemCardapio>

    @Query("select * from $TABLE_ITEM_CARDAPIO where $COLUMN_ESTABELECIMENTO_ID = :idEstabelecimentoDao")
    fun getTodosOsItensByEstabelecimento(idEstabelecimentoDao: Long): LiveData<List<ItemCardapio>>

    @Query("select * from $TABLE_ITEM_CARDAPIO where $COLUMN_ESTABELECIMENTO_ID = :idEstabelecimento and $COLUMN_ITEM_CARDAPIO_CATEGRIA = :categoria")
    fun getTodosOsItensByCategoria(idEstabelecimento: Long, categoria: Categoria): LiveData<List<ItemCardapio>>

    @Query("select distinct $COLUMN_ITEM_CARDAPIO_CATEGRIA as c from $TABLE_ITEM_CARDAPIO where $COLUMN_ESTABELECIMENTO_ID = :idEstabelecimento order by c")
    fun getCategorias(idEstabelecimento: Long): LiveData<List<Categoria>>
}