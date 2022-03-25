package br.uea.transirie.mypay.mycoffee.enums

enum class Categoria() {
    Acai{ override fun nomeCategoria(): String = "Açai" },
    BebidasGeladas{ override fun nomeCategoria(): String = "Bebidas Geladas" },
    BebidasQuentes{ override fun nomeCategoria(): String = "Bebidas Quentes" },
    Bolo{ override fun nomeCategoria(): String = "Bolo" },
    Combo{ override fun nomeCategoria(): String = "Combo" },
    Crepioca{ override fun nomeCategoria(): String = "Crepioca" },
    Cuscuz{ override fun nomeCategoria(): String = "Cuscuz" },
    Doces{ override fun nomeCategoria(): String = "Doces" },
    Especiais{ override fun nomeCategoria(): String = "Especiais" },
    Farofa{ override fun nomeCategoria(): String = "Farofa" },
    Fit{ override fun nomeCategoria(): String = "Fit" },
    LanchesNaturais{ override fun nomeCategoria(): String = "Lanches Naturais" },
    Omeletes{ override fun nomeCategoria(): String = "Omeletes" },
    Outros{ override fun nomeCategoria(): String = "Outros" },
    Panquecas{ override fun nomeCategoria(): String = "Panquecas" },
    Porcoes{ override fun nomeCategoria(): String = "Porções" },
    PratosRapidos{ override fun nomeCategoria(): String = "Pratos Rápidos" },
    Promocionais{ override fun nomeCategoria(): String = "Pratos Rapidos" },
    Saladas{ override fun nomeCategoria(): String = "Promocionais" },
    Salgados{ override fun nomeCategoria(): String = "Salgados" },
    Sanduiches{ override fun nomeCategoria(): String = "Sanduiches" },
    Sobremesas{ override fun nomeCategoria(): String = "Sobremesas" },
    Tapiocas{ override fun nomeCategoria(): String = "Tapiocas" },
    Tortas{ override fun nomeCategoria(): String = "Tortas" },
    Vitaminas{ override fun nomeCategoria(): String = "Vitaminas" },;

    abstract fun nomeCategoria(): String

    companion object{
        fun from(txtCategoria: String): Categoria = Categoria.values().first{ it.nomeCategoria() == txtCategoria}
    }

}