package br.uea.transirie.mypay.mycoffee.repository.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import br.uea.transirie.mypay.mycoffee.model.Produto
import br.uea.transirie.mypay.mycoffee.repository.sqlite.*

@Dao
interface ProdutoDao: BaseDao<Produto> {
    @Query("SELECT * FROM $TABLE_PRODUTO")
    fun getAll(): LiveData<List<Produto>>

    @Query("select * from $TABLE_PRODUTO where $COLUMN_ESTABELECIMENTO_ID = :idEstabelecimento")
    fun produtosByEstabelecimento(idEstabelecimento: Long):LiveData<List<Produto>>

    @Transaction
    @Query("SELECT *FROM $TABLE_PRODUTO WHERE $COLUMN_ID =  :id")
    fun infoProdutoCadastrado(id: Long): Produto

    @Transaction
    @Query("UPDATE $TABLE_PRODUTO SET $COLUMN_NOME_ITEM= :nomeItem ,$COLUMN_QUANTIDADE= :quantidade, $COLUMN_UNIDADE_MEDIDA= :unidMed, $COLUMN_STATUS_SERVICO= :statusServ WHERE  $COLUMN_ID= :id")
    fun updateProduto(id:Long, nomeItem:String, quantidade:Float, unidMed: String, statusServ:Boolean): Int
}