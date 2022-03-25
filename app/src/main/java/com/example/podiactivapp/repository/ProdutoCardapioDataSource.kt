package br.uea.transirie.mypay.mycoffee.repository

import androidx.lifecycle.LiveData
import br.uea.transirie.mypay.mycoffee.model.ItemCardapioComProduto
import br.uea.transirie.mypay.mycoffee.model.ProdutoDoCardapio

interface ProdutoCardapioDataSource: BaseDataSource<ProdutoDoCardapio> {
    fun getProdutosCardapioByItemCardapioId(id: Long): LiveData<List<ItemCardapioComProduto>>
    fun deleteProdutoCardapioById(idProdutoCardapio:Long)
}