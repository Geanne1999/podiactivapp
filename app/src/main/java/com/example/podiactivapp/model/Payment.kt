package br.uea.transirie.mypay.mycoffee.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import br.uea.transirie.mypay.mycoffee.enums.TipoPagamento
import br.uea.transirie.mypay.mycoffee.repository.sqlite.*
import java.time.LocalDate

@Entity(tableName = TABLE_PAGAMENTO)
class Payment(
    //  TODO
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_PAGAMENTO_ID) var id: Long = 0,
    @ColumnInfo(name = COLUMN_ESTABELECIMENTO_ID) var atendimentoId: Long = 0,
    @ColumnInfo(name = COLUMN_VALOR) var valor: Float = 0f,
    @ColumnInfo(name = COLUMN_DATA_PAGAMENTO) var dataPagamento: String = "",
    @ColumnInfo(name = COLUMN_TIPO_PAGAMENTO) var tipoPagamento: TipoPagamento
){
    object dataHoje{
        var dataHoje: LocalDate = LocalDate.now()
    }
    object caixaInicial{
        var valorCaixaInicial: Float =0f
    }
    object totalClientes{
        var totalCliente: Int = 0 // variável que armazena o total de clientes do dia
    }
    object dinheiroRecebimento{
        var valorDinheiro: Float = 0f
    }
    object creditoRecebimento{
        var valorCredito: Float = 0f
    }
    object debitoRecebimento{
        var valorDebito: Float = 0f
    }
    object despesasCartao{
        var valorDespesasCartaoCredito: Float = 0f
        var valorDespesasCartaoDebito: Float = 0f
    }
    object despesasDinheiro{
        var valorDespesasDinheiroDia: Float = 0f
    }
}