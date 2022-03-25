package br.uea.transirie.mypay.mycoffee.repository

import androidx.lifecycle.LiveData
import br.uea.transirie.mypay.mycoffee.enums.Categoria
import br.uea.transirie.mypay.mycoffee.model.ItemCardapio

interface ItemCardapioDataSource: BaseDataSource<ItemCardapio> {
    fun itemCardapioByID(id: Long): LiveData<ItemCardapio>
    fun getTodosOsItensByEstabelecimento(idEstabelecimentoDao: Long) : LiveData<List<ItemCardapio>>
    fun getTodosOsItensByCategoria(idEstabelecimentoDao: Long, categoria: Categoria) : LiveData<List<ItemCardapio>>
    fun getCategorias(idEstabelecimento: Long): LiveData<List<Categoria>>
}