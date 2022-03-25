package br.uea.transirie.mypay.mycoffee.repository

import androidx.lifecycle.LiveData
import br.uea.transirie.mypay.mycoffee.model.Client

interface ClientDataSource: BaseDataSource<Client> {
    fun estabelecimentoByEmailESenha(email: String, senha: String): Client?
    fun estabelecimentoById(id: Long): LiveData<Client>
    fun usuarioEstaRegistrado(nomeUsuario: String): Client
    fun searchEstabelecimentoByEmail(email: String): LiveData<Client>
    fun verificaEstabelecimento(email: String, cnpj: String, razaoSocial: String): LiveData<Client>
}