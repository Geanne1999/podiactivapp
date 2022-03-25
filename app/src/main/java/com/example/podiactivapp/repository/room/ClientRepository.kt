package br.uea.transirie.mypay.mycoffee.repository.room

import androidx.lifecycle.LiveData
import br.uea.transirie.mypay.mycoffee.model.Client
import br.uea.transirie.mypay.mycoffee.repository.ClientDataSource

class ClientRepository(database: AppDatabase): ClientDataSource {
    private val estabelecimentoDao = database.clientDao()

    private lateinit var client: LiveData<Client>

    override fun estabelecimentoByEmailESenha(email: String, senha: String): Client? {
        return estabelecimentoDao.estabelecimentoByEmailESenha(email, senha)
    }

    override fun estabelecimentoById(id: Long): LiveData<Client> {
        client = estabelecimentoDao.estabelecimentoById(id)
        return client
    }
    fun getAllUsuarios(): List<Client> {
        return estabelecimentoDao.getAllUsuarios()
    }

    override fun searchEstabelecimentoByEmail(email: String): LiveData<Client> {
        return estabelecimentoDao.searchEstabelecimentoByEmail(email)
    }

    override fun verificaEstabelecimento(email: String, cnpj: String, razaoSocial: String): LiveData<Client> {
        return estabelecimentoDao.verificaEstabelecimento(email, cnpj, razaoSocial)
    }

    override fun save(obj: Client) : Long {
        return if (obj.id == 0L){
            insert(obj)
        }else{
            update(obj)
            obj.id
        }
    }

    override fun usuarioEstaRegistrado(nomeUsuario: String): Client {
        return estabelecimentoDao.getUsuario(nomeUsuario)
    }

    override fun insert(obj: Client): Long {
        return estabelecimentoDao.insert(obj)
    }

    override fun update(obj: Client) {
        return estabelecimentoDao.update(obj)
    }

    override fun delete(obj: Client) {
        return estabelecimentoDao.delete(obj)
    }
}