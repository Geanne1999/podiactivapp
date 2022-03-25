package br.uea.transirie.mypay.mycoffee.repository.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.uea.transirie.mypay.mycoffee.enums.Categoria
import br.uea.transirie.mypay.mycoffee.enums.StatusMesa
import br.uea.transirie.mypay.mycoffee.model.*
import br.uea.transirie.mypay.mycoffee.repository.room.converters.*
import br.uea.transirie.mypay.mycoffee.repository.room.dao.*
import br.uea.transirie.mypay.mycoffee.repository.sqlite.DATABASE_NAME
import br.uea.transirie.mypay.mycoffee.repository.sqlite.DATABASE_VERSION
import br.uea.transirie.mypay.mypaytemplate.repository.room.converters.LocalDateConverter
import br.uea.transirie.mypay.mypaytemplate.repository.room.converters.LocalDateTimeConverter

@Database(
    entities = [
        Client::class,
        ItemCardapio::class,
        ItemComanda::class,
        Transacao::class,
        Payment::class,
        Produto::class,
        Comanda::class,
        Mesa::class,
        ClienteListaEspera::class,
        ProdutoDoCardapio::class,
        Despesa::class
    ], version = DATABASE_VERSION, exportSchema = false
)
@TypeConverters(
    LocalDateTimeConverter::class,
    LocalDateConverter::class,
    LocalTimeConverter::class,
    CategoriaConverter::class,
    TipoPagamentoConverter::class,
    TipoEstoqueConverter::class,
    TipoTransacaoConverter::class
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun clientDao(): ClientDao
    abstract fun itemCardapioDao(): ItemCardapioDao
    abstract fun itemComandaDao(): ItemComandaDao
    abstract fun transacaoDao(): TransacaoDao
    abstract fun pagamentoDao(): PaymentDao
    abstract fun produtoDao(): ProdutoDao
    abstract fun comandaDao(): ComandaDao
    abstract fun mesaDao(): MesaDao//it will not be here anymore
    abstract fun clienteListaEsperaDao():ClienteListaEsperaDao
    abstract fun produtoCardapioDao():ProdutoCardapioDao
    abstract fun despesaDao(): DespesaDao

    companion object {
        private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            if (instance == null) {
                synchronized(this) {
                    instance =
                        Room.databaseBuilder(
                            context.applicationContext,
                            AppDatabase::class.java,
                            DATABASE_NAME
                        )
                            /*
                            .addCallback(object : Callback() {
                                override fun onCreate(db: SupportSQLiteDatabase) {
                                    super.onCreate(db)
                                    doAsync {
                                        PREPOPULATE_ESTABELECIMENTO.forEach {
                                            getDatabase(context).estabelecimentoDao().insert(it)
                                        }

                                        PREPOPULATE_ITEM_CARDAPIO.forEach {
                                            getDatabase(context).itemCardapioDao().insert(it)
                                        }

                                        PREPOPULATE_MESAS.forEach{
                                            getDatabase(context).mesaDao().insert(it)
                                        }

                                        PREPOLATE_PRODUTOS.forEach {
                                            getDatabase(context).produtoDao().insert(it)
                                        }
                                    }
                                }
                            })
                            */
                            .build()
                }
            }
            return instance as AppDatabase
        }

        val PREPOPULATE_ESTABELECIMENTO = listOf(
            Client(
                id = 1,
                email = "a@b.c",
                cnpj = "04.259.447/0001-30",
                endereco = "P. Sherman, 42, Wallaby Way, Sydney",
                nomeFantasia = "my coffee test",
                razaoSocial = "MyCoffee App",
                senhaObfuscated = "123456",
                telefone = "(92)98765-4321",
                mesas = 6
            ),
            Client(
                id = 2,
                email = "edufpaiva33@gmail.com",
                cnpj = "70.396.421/0001-69",
                endereco = "P. Sherman, 42, Wallaby Way, Sydney",
                nomeFantasia = "Eduds",
                razaoSocial = "Edufpaiva",
                senhaObfuscated = "a",
                telefone = "(92)98765-4321",
            )
        )

        val PREPOPULATE_ITEM_CARDAPIO = listOf(
            ItemCardapio(1, 1, "Café", 2.00, Categoria.BebidasQuentes),
            ItemCardapio(2, 1, "Café com leite", 2.50, Categoria.BebidasQuentes),
            ItemCardapio(3, 1, "Capuccino", 5.00, Categoria.BebidasQuentes),
            ItemCardapio(4, 1, "Mixto", 4.00, Categoria.Sanduiches),
            ItemCardapio(5, 1, "Queijo", 3.00, Categoria.Sanduiches),
            ItemCardapio(6, 1, "Hamburguer de siri", 8.00, Categoria.Sanduiches),
            ItemCardapio(7, 1, "Latte Machiato", 6.00, Categoria.BebidasQuentes),
            ItemCardapio(8, 1, "Bolo de Chocolate", 3.50, Categoria.Bolo),
            ItemCardapio(9, 1, "Pão de Queijo", 0.50, Categoria.Salgados),
            ItemCardapio(10, 1, "Torta de Frango", 3.00, Categoria.Salgados),
            ItemCardapio(11, 1, "Expresso", 1.75, Categoria.BebidasQuentes),
            ItemCardapio(12, 1, "Coca-Cola", 3.99, Categoria.BebidasGeladas),
            ItemCardapio(13, 1, "Pepsi", 3.99, Categoria.BebidasGeladas),
            ItemCardapio(14, 1, "Suco Natural", 5.00, Categoria.BebidasGeladas),
            ItemCardapio(15, 2, "Café", 2.00, Categoria.BebidasQuentes),
            ItemCardapio(16, 2, "Café com leite", 2.50, Categoria.BebidasQuentes),
            ItemCardapio(17, 2, "Capuccino", 5.00, Categoria.BebidasQuentes),
            ItemCardapio(18, 2, "Mixto", 4.00, Categoria.Sanduiches),
            ItemCardapio(19, 2, "Queijo", 3.00, Categoria.Sanduiches),
            ItemCardapio(20, 2, "Hamburguer de siri", 8.00, Categoria.Sanduiches),
            ItemCardapio(21, 2, "Latte Machiato", 6.00, Categoria.BebidasQuentes),
            ItemCardapio(22, 2, "Bolo de Chocolate", 3.50, Categoria.Bolo),
            ItemCardapio(23, 2, "Pão de Queijo", 0.50, Categoria.Salgados),
            ItemCardapio(24, 2, "Torta de Frango", 3.00, Categoria.Salgados),
            ItemCardapio(25, 2, "Expresso", 1.75, Categoria.BebidasQuentes),
            ItemCardapio(26, 2, "Coca-Cola", 3.99, Categoria.BebidasGeladas),
            ItemCardapio(27, 2, "Pepsi", 3.99, Categoria.BebidasGeladas),
            ItemCardapio(28, 2, "Suco Natural", 5.00, Categoria.BebidasGeladas),
        )

        val PREPOPULATE_MESAS = listOf (
            Mesa(1, 1, StatusMesa.Vazia),
            Mesa(2, 1, StatusMesa.Vazia),
            Mesa(3, 1, StatusMesa.Vazia),
            Mesa(4, 1, StatusMesa.Vazia),
            Mesa(5, 1, StatusMesa.Vazia),
            Mesa(6, 1, StatusMesa.Vazia)
        )

        val PREPOLATE_PRODUTOS = listOf(
            Produto(0, 1, "Pão", 30f, "Unidade"),
            Produto(0, 1, "Queijo", 92f, "Unidade"),
            Produto(0, 1, "Presunto", 47f, "Unidade"),
            Produto(0, 1, "Tucumã", 30f, "Unidade"),
            Produto(0, 1, "Pão de forma", 40f, "Unidade"),
            Produto(0, 1, "Queijo Coalho", 30f, "Unidade"),
            Produto(0, 1, "Banana", 12f, "Unidade"),
            Produto(0, 1, "Siri", 2f, "Unidade"),
        )


        fun destroyInstance() {
            instance = null
        }
    }
}