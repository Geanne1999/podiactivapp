package br.uea.transirie.mypay.mycoffee.repository.room

import androidx.lifecycle.LiveData
import br.uea.transirie.mypay.mycoffee.model.ItemCardapioComProduto
import br.uea.transirie.mypay.mycoffee.model.Produto
import br.uea.transirie.mypay.mycoffee.model.ProdutoDoCardapio
import br.uea.transirie.mypay.mycoffee.repository.ProdutoCardapioDataSource
import br.uea.transirie.mypay.mycoffee.repository.ProdutoDataSource

class ProdutoCardapioRepository (database: AppDatabase): ProdutoCardapioDataSource {
    private val produtoCardapioDao=database.produtoCardapioDao()

    override fun save(obj: ProdutoDoCardapio) : Long {
        return if (obj.id == 0L){
            insert(obj)
        }else{
            update(obj)
            obj.id
        }
    }
    override fun insert(obj: ProdutoDoCardapio): Long {
        return produtoCardapioDao.insert(obj)
    }

    override fun update(obj: ProdutoDoCardapio) {
        return produtoCardapioDao.update(obj)
    }
    override fun delete(obj: ProdutoDoCardapio) {
        return produtoCardapioDao.delete(obj)
    }
    override fun getProdutosCardapioByItemCardapioId(id: Long): LiveData<List<ItemCardapioComProduto>> {
        return produtoCardapioDao.getProdutosCardapioByItemCardapioId(id)
    }

    override fun deleteProdutoCardapioById(idProdutoCardapio:Long) {
        return produtoCardapioDao.deleteProdutoCardapioById(idProdutoCardapio)
    }
}