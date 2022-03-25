package br.uea.transirie.mypay.mycoffee.model

import androidx.room.Embedded
import androidx.room.Relation
import br.uea.transirie.mypay.mycoffee.repository.sqlite.COLUMN_ID
import br.uea.transirie.mypay.mycoffee.repository.sqlite.COLUMN_ITEM_CARDAPIO_ID
import br.uea.transirie.mypay.mycoffee.repository.sqlite.COLUMN_PRODUTO_ID

data class ItemCardapioComProduto(
    @Embedded var produtoCardapio: ProdutoDoCardapio,
    @Relation(
        parentColumn = COLUMN_PRODUTO_ID,
        entityColumn = COLUMN_ID
    )
    var produto: Produto
){
}