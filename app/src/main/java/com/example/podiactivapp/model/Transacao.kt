package br.uea.transirie.mypay.mycoffee.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import br.uea.transirie.mypay.mycoffee.enums.TipoTransacao
import br.uea.transirie.mypay.mycoffee.repository.sqlite.*
import java.time.LocalDate

@Entity(tableName = TABLE_TRANSACAO)
data class Transacao(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_TRANSACAO_ID) var id: Long = 0,
    @ColumnInfo(name = COLUMN_ESTABELECIMENTO_ID) var idEstabelecimento: Long = 0,
    @ColumnInfo(name = COLUMN_TRANSACAO_VALOR) var valor: Double = 0.0,
    @ColumnInfo(name = COLUMN_TRANSACAO_DATA) var data: LocalDate = LocalDate.now(),
    @ColumnInfo(name = COLUMN_TRANSACAO_TIPO) var tipo: TipoTransacao = TipoTransacao.CAIXA_INICIAL,
    @ColumnInfo(name = COLUMN_TRANSACAO_DESPESA) var isDespesa: Boolean = true,
    @ColumnInfo(name= COLUMN_COMANDA_ID) var idComanda: Long = 0
)