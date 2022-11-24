package com.example.gerenciadordeprodutos.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gerenciadordeprodutos.Produto

import com.example.gerenciadordeprodutos.R
import com.example.gerenciadordeprodutos.holder.ProdutoHolder

class AdapterProduto (private val produto: List<Produto>?,val context: Context):
    RecyclerView.Adapter<ProdutoHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoHolder {
        return ProdutoHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_produtos,parent,false)
        )
    }

    override fun onBindViewHolder(holder: ProdutoHolder, position: Int) {
        holder.nomeProd.text = produto!![position].nomeProd
        holder.preco.text = "R$${produto!![position].preco.toString()}"
        holder.quantidade.text=produto!![position].quantidade.toString()
    }

    override fun getItemCount(): Int {
        return produto?.size ?: 0
    }


}