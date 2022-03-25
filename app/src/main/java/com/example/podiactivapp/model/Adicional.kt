package br.uea.transirie.mypay.mycoffee.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import br.uea.transirie.mypay.mycoffee.enums.Categoria
import br.uea.transirie.mypay.mycoffee.repository.sqlite.*

@Entity(tableName = TABLE_ADICIONAL)
data class Adicional(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID) var id: Long = 0,
    @ColumnInfo(name = COLUMN_ADICIONAL_NOME) var nome: String = "",
    @ColumnInfo(name = COLUMN_ADICIONAL_VALOR) var valor: Double = 0.0,
    @ColumnInfo(name = COLUMN_ADICIONAL_CATEGORIA) var categoria: Categoria = Categoria.Outros
)