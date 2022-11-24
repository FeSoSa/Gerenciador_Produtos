package com.example.gerenciadordeprodutos

import java.io.Serializable

class Produto(val id:Int, val nomeProd: String, val quantidade :Int, val preco :Double): Serializable {

    override fun equals(o: Any?): Boolean {
        return  id == (o as Produto?)!!.id
    }

    override fun hashCode(): Int {
        return id
    }
}