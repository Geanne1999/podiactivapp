package br.uea.transirie.mypay.mycoffee.repository.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import br.uea.transirie.mypay.mycoffee.model.Client
import br.uea.transirie.mypay.mycoffee.repository.sqlite.*

@Dao
interface ClientDao: BaseDao<Client> {

    @Query("""SELECT * FROM $TABLE_ESTABELECIMENTO WHERE $COLUMN_ID = :id""")
    fun estabelecimentoById(id: Long): LiveData<Client>

    /**
     * Realiza consulta por meio do email do estabelecimento
     */
    @Query("""SELECT * FROM $TABLE_ESTABELECIMENTO WHERE $COLUMN_EMAIL = :email""")
    fun estabelecimentoByEmail(email: String): LiveData<Client>

    @Query("SELECT * FROM $TABLE_ESTABELECIMENTO WHERE $COLUMN_EMAIL = :email")
    fun searchEstabelecimentoByEmail(email: String): LiveData<Client>

    @Query("SELECT * FROM $TABLE_ESTABELECIMENTO")
    fun getAllUsuarios(): List<Client>

    @Query("SELECT * FROM $TABLE_ESTABELECIMENTO WHERE $COLUMN_EMAIL = :email")
    fun getUsuario(email: String): Client

    /**
     * Consulta o valor por meio da coluna a senha do estabelecimento
     */
    @Query("""SELECT * FROM $TABLE_ESTABELECIMENTO WHERE $COLUMN_SENHA_OBFUSCATED = :senha""")
    fun estabelecimentoBySenha(senha: String): LiveData<Client>

    /**
     * Recupera um Estabelecendo através do email e senha
     */
    @Query("""SELECT * FROM $TABLE_ESTABELECIMENTO WHERE $COLUMN_EMAIL = :email AND $COLUMN_SENHA_OBFUSCATED = :senha""")
    fun estabelecimentoByEmailESenha(email: String, senha: String): Client?

    @Query("""SELECT * FROM $TABLE_ESTABELECIMENTO""")
    fun getEstabelecimento(): LiveData<Client>

    //Faz a consulta do id na tabela
    @Query("SELECT _id FROM $TABLE_ESTABELECIMENTO LIMIT 1")
    fun estabelecimentoIds(): Long

    @Query("SELECT * FROM $TABLE_ESTABELECIMENTO")
    fun getAllEstabelecimentos(): LiveData<List<Client>>

    @Query("SELECT * FROM $TABLE_ESTABELECIMENTO WHERE $COLUMN_EMAIL = :emailEstabelecimento")
    fun getEstabelecimento(emailEstabelecimento: String): LiveData<Client>

    @Query("select * from $TABLE_ESTABELECIMENTO where $COLUMN_EMAIL = :email or $COLUMN_CNPJ = :cnpj or $COLUMN_RAZAO_SOCIAL = :razaoSocial")
    fun verificaEstabelecimento(
        email: String,
        cnpj: String,
        razaoSocial: String
    ):LiveData<Client>
}