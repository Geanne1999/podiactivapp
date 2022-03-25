package br.uea.transirie.mypay.mycoffee.repository.room

import androidx.lifecycle.LiveData
import br.uea.transirie.mypay.mycoffee.model.Produto
import br.uea.transirie.mypay.mycoffee.repository.ProdutoDataSource

class ProdutoRepository(database: AppDatabase): ProdutoDataSource {
    private val produtoDao=database.produtoDao()

    override fun save(obj: Produto) : Long {
        return if (obj.id == 0L){
            insert(obj)
        }else{
            update(obj)
            obj.id
        }
    }
    override fun insert(obj: Produto): Long {
        return produtoDao.insert(obj)
    }

    override fun update(obj: Produto) {
        return produtoDao.update(obj)
    }

    override fun delete(obj: Produto) {
        return produtoDao.delete(obj)
    }
    fun getAll(): LiveData<List<Produto>> {
        return produtoDao.getAll()
    }
    override fun updateProduto(
        id: Long,
        nomeItem: String,
        quantidade: Float,
        unidMed: String,
        statusServ:Boolean
    ): String {
        return produtoDao.updateProduto(id, nomeItem, quantidade, unidMed, statusServ).toString()
    }
    override fun infoProdutoCadastrado(id: Long): Produto {
        return produtoDao.infoProdutoCadastrado(id)
    }

    override fun produtosByEstabelecimento(idEstabelecimento: Long): LiveData<List<Produto>> {
        return produtoDao.produtosByEstabelecimento(idEstabelecimento)
    }
}