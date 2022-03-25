package br.uea.transirie.mypay.mycoffee.repository

import androidx.lifecycle.LiveData
import br.uea.transirie.mypay.mycoffee.model.Produto

interface ProdutoDataSource: BaseDataSource<Produto> {
    fun updateProduto(id:Long, nomeItem:String, quantidade:Float, unidMed: String, statusServ:Boolean): String
    fun infoProdutoCadastrado(id: Long): Produto
    fun produtosByEstabelecimento(idEstabelecimento: Long): LiveData<List<Produto>>
}