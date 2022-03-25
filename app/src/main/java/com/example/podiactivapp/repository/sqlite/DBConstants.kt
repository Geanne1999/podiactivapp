package br.uea.transirie.mypay.mycoffee.repository.sqlite

const val DATABASE_VERSION = 1
const val DATABASE_NAME = "dbApp"

const val TABLE_SERVICO = "servico"
const val TABLE_CLIENTE_LISTA_ESPERA="clienteListaEspera"
const val TABLE_CLIENTE = "cliente"
const val TABLE_PRODUTO = "produto"
const val TABLE_ATENDIMENTO = "atendimento"
const val TABLE_PERGUNTA = "pergunta"
const val TABLE_ESTABELECIMENTO = "estabelecimento"
const val TABLE_ESTOQUE = "itemeEstoque"
const val PREF_VERIF_ABRIR_CAIXA = "verifAbrirCaixa"
const val TABLE_ITEM_ATENDIMENTO = "itemAtendimento"
const val TABLE_DESPESA = "despesa"
const val COLUMN_ID = "_id"
const val COLUMN_ESTABELECIMENTO_ID = "_idEstabelecimento"
const val COLUMN_CLIENTE_ID = "clienteId"
const val COLUMN_DESCRICAO = "descricao"
const val COLUMN_STATUS_SERVICO="statusServ"
const val COLUMN_PRECO = "preco"
const val COLUMN_DATA_RECEBIMENTO = "dataRecebimento"
const val COLUMN_DATA_PREVISAO_ENTREGA = "dataPrevisaoEntrega"
const val COLUMN_DATA_CONCLUSAO = "dataConclusao"
const val COLUMN_USUARIO = "usuario"
const val COLUMN_VALOR_TOTAL = "valorTotal"
const val COLUMN_NOME = "nome"
const val COLUMN_EMAIL = "email"
const val COLUMN_DATA_NASCIMENTO = "dataNascimento"
const val COLUMN_CPF = "cpf"
const val COLUMN_SENHA_OBFUSCATED = "senhaObfuscated"
const val COLUMN_NOME_FANTASIA = "nomeFantasia"
const val COLUMN_RAZAO_SOCIAL = "razaoSocial"
const val COLUMN_PERGUNTA_SEGURANCA="perguntaSeguranca"
const val COLUMN_CNPJ = "cnpj"
const val COLUMN_TELEFONE = "telefone"
const val COLUMN_ENDERECO = "endereco"
const val COLUMN_MESAS = "mesas"
const val COLUMN_ATENDIMENTO_ID = "atendimentoId"
const val COLUMN_HORARIO_RECEBIMENTO = "horarioRecebimento"
const val COLUMN_SERVICO_ID = "servicoId"
const val COLUMN_ITEM_ATENDIMENTO_ID = "itemAtendimentoId"
const val COLUMN_CATEGORIA = "categoria"
const val COLUMN_ESTOQUE_QUANTIDADE = "Quantidade"
const val COLUMN_QUANTIDADE = "quantidade"
const val COLUMN_NOME_ITEM="nomeItem"
const val COLUMN_UNIDADE_MEDIDA="unidadeMed"

//Cliente lista de espera
const val COLUMN_NOME_CLIENTE_LISTA_ESPERA="nomeClienteListaEspera"
const val COLUMN_QUANTIDADE_LISTA_ESPERA="quantidadePessoasListaEspera"

//  Item Comanda
const val TABLE_ITEM_CARDAPIO = "itemCardapio"

const val COLUMN_ITEM_CARDAPIO_ID = "itemCardapioID"
const val COLUMN_ITEM_CARDAPIO_NOME = "itemCardapioNome"
const val COLUMN_ITEM_CARDAPIO_PRECO = "itemCardapioPreco"
const val COLUMN_ITEM_CARDAPIO_CATEGRIA = "itemCardapioCategoria"

//  Transacao
const val TABLE_TRANSACAO = "transacao"

const val COLUMN_TRANSACAO_ID = "transacaoID"
const val COLUMN_TRANSACAO_VALOR = "transacaoValor"
const val COLUMN_TRANSACAO_DATA = "transacaoData"
const val COLUMN_TRANSACAO_TIPO = "transacaoTipo"
const val COLUMN_TRANSACAO_DESPESA = "transacaoDespesa"

// Pagamento

const val TABLE_PAGAMENTO = "pagamento"

const val COLUMN_PAGAMENTO_ID = "PagamentoID"
const val COLUMN_DATA_PAGAMENTO = "dataPagamento"
const val COLUMN_VALOR = "valor"
const val COLUMN_TIPO_PAGAMENTO = "tipoPagamento"


//  Adicional
const val TABLE_ADICIONAL = "adicional"

const val COLUMN_ADICIONAL_NOME = "adicionalNome"
const val COLUMN_ADICIONAL_VALOR = "adicionalValor"
const val COLUMN_ADICIONAL_CATEGORIA = "adicionalCategoria"
const val COLUMN_ADICIONAL_QUANTIDADE = "adicionalQuantidade"

//Ajuda
const val COLUMN_PERGUNTA = "pergunta"
const val COLUMN_RESPOSTA = "resposta"


// Mesa
const val TABLE_MESA = "mesa"
const val COLUMN_MESA_ID = "mesaID"
const val COLUMN_MESA_STATUS = "mesaStatus"

//  Comanda
const val TABLE_COMANDA = "comanda"

const val COLUMN_COMANDA_ID = "comandaID"
const val COLUMN_COMANDA_ATIVA = "comandaAtiva"
const val COLUMN_COMANDA_DATE = "comandaData"
const val COLUMN_COMANDA_TIME = "comandaHora"

//  Item Comanda
const val TABLE_ITEM_COMANDA = "itemComanda"

const val COLUMN_ITEM_COMANDA_ID = "itemComandaID"
const val COLUMN_ITEM_COMANDA_OBSERVACOES = "itemComandaObservacoes"
const val COLUMN_ITEM_COMANDA_QUANIDADE = "itemComandaQuantidade"

const val PREF_DATA_NAME = "dadosCadastroEmpresa"
const val PREF_USER_ID = "user_id"
const val PREF_PRIMEIRO_USO = "user_primeiro_uso"

const val TABLE_PRODUTO_DO_CARDAPIO = "tabelaProdutoCardapio"
const val COLUMN_PRODUTO_DO_CARDAPIO_ID = "produtoCardapioNome"
const val COLUMN_PRODUTO_ID = "produtoID"



