package br.uea.transirie.mypay.mycoffee.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import br.uea.transirie.mypay.mycoffee.enums.StatusMesa
import br.uea.transirie.mypay.mycoffee.repository.sqlite.*


@Entity(tableName = TABLE_MESA)
data class Mesa(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_MESA_ID) var idMesa: Long = 0L,
    @ColumnInfo(name = COLUMN_ESTABELECIMENTO_ID) var idEstabelecimento: Long = 0L,
    @ColumnInfo(name = COLUMN_MESA_STATUS) var status: StatusMesa = StatusMesa.Vazia
)
