package br.uea.transirie.mypay.mycoffee.model

import androidx.room.Embedded
import androidx.room.Relation
import br.uea.transirie.mypay.mycoffee.repository.sqlite.COLUMN_COMANDA_ID

data class ComandaComItens(
    var comanda: Comanda,
    val itens: List<ItemComandaComItem>
)