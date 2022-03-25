package br.uea.transirie.mypay.mycoffee.repository.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import br.uea.transirie.mypay.mycoffee.model.ItemCardapioComProduto
import br.uea.transirie.mypay.mycoffee.model.Produto
import br.uea.transirie.mypay.mycoffee.model.ProdutoDoCardapio
import br.uea.transirie.mypay.mycoffee.repository.sqlite.*

@Dao
interface ProdutoCardapioDao: BaseDao<ProdutoDoCardapio> {
    @Transaction
    @Query("SELECT *FROM $TABLE_PRODUTO_DO_CARDAPIO WHERE $COLUMN_ITEM_CARDAPIO_ID =  :id")
    fun getProdutosCardapioByItemCardapioId(id: Long): LiveData<List<ItemCardapioComProduto>>

    @Transaction
    @Query("DELETE FROM $TABLE_PRODUTO_DO_CARDAPIO WHERE $COLUMN_PRODUTO_DO_CARDAPIO_ID =  :idProdutoCardapio")
    fun deleteProdutoCardapioById(idProdutoCardapio:Long)
}