package br.uea.transirie.mypay.mycoffee.repository

import br.uea.transirie.mypay.mycoffee.model.Despesa


interface DespesaDataSource: BaseDataSource<Despesa> {
    fun getAllDespesa(): List<Despesa>
}