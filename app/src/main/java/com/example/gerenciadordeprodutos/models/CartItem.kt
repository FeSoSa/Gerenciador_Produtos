package com.example.gerenciadordeprodutos.models

class CartItem {

    private var produtoModel: ProdutoModel? = null
    private var quantidadeItem = 0

    fun CartItem(produtoModel: ProdutoModel?, quantity: Int) {
        this.produtoModel = produtoModel
        this.quantidadeItem = quantity
    }
    fun String(): String {
        return "CartItem{"+
                "produtoModel="+produtoModel+
                ",quantidadeItem="+quantidadeItem+
                "}";
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CartItem

        if (produtoModel != other.produtoModel) return false
        if (quantidadeItem != other.quantidadeItem) return false

        return true
    }



}