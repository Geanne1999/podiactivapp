package br.uea.transirie.mypay.mycoffee.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import br.uea.transirie.mypay.mycoffee.enums.Estoque
import br.uea.transirie.mypay.mycoffee.repository.sqlite.*

@Entity(tableName = TABLE_ESTOQUE)
data class ItemEstoque(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID) var id: Long = 0,
    @ColumnInfo(name = COLUMN_ESTABELECIMENTO_ID) var idEstabelecimento: Long = 0,
    @ColumnInfo(name = COLUMN_NOME) var nome: String = "",
    @ColumnInfo(name = COLUMN_PRECO) var preco: Double = 0.0,
    @ColumnInfo(name = COLUMN_ESTOQUE_QUANTIDADE) var quantidade: Estoque){
    object primeiroAcessoEstoque{
        var acesso:Boolean=false
    }
    object listaItensEstoque{
        var itemEstoque:ArrayList<Produto> = arrayListOf()
    }
}
