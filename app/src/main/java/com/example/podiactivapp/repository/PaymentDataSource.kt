package br.uea.transirie.mypay.mycoffee.repository

import br.uea.transirie.mypay.mycoffee.model.Payment

interface PaymentDataSource: BaseDataSource<Payment> {
    fun getAllPagamentos(): List<Payment>
}