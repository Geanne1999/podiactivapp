package br.uea.transirie.mypay.mycoffee.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import br.uea.transirie.mypay.mycoffee.repository.sqlite.*
import kotlinx.android.parcel.Parcelize
import java.time.LocalDate
import java.time.LocalTime

@Parcelize
@Entity(tableName = TABLE_COMANDA)
data class Comanda(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_COMANDA_ID) var comandaID: Long = 0,
    @ColumnInfo(name = COLUMN_MESA_ID) var mesaID: Long = 0,
    @ColumnInfo(name = COLUMN_ESTABELECIMENTO_ID) var estabelecimentoID: Long = 0,
    @ColumnInfo(name = COLUMN_COMANDA_ATIVA) var ativa: Boolean = true,
    @ColumnInfo(name = COLUMN_COMANDA_DATE) var data: LocalDate = LocalDate.now(),
    @ColumnInfo(name = COLUMN_COMANDA_TIME) var hora: LocalTime = LocalTime.now(),
    @ColumnInfo(name = COLUMN_VALOR_TOTAL) var  valorTotal: Double = 0.0
) : Parcelable