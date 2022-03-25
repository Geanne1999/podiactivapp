package br.uea.transirie.mypay.mycoffee.enums

enum class StatusMesa() {
    Vazia {
        override fun toString() = "Vazia"
    },
    EmAtendimento {
        override fun toString() = "Em Atendimento"
    },
    Reservada {
        override fun toString() = "Reservada"
    },
    Indisponivel {
        override fun toString() = "Indisponível"
    };
}
