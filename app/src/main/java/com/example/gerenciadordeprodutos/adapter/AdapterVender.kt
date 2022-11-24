package com.example.gerenciadordeprodutos.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.gerenciadordeprodutos.Produto
import com.example.gerenciadordeprodutos.R
import com.example.gerenciadordeprodutos.holder.ProdutoHolder
import com.example.gerenciadordeprodutos.holder.VenderHolder
import java.lang.reflect.WildcardType
import java.util.*

class AdapterVender (private val produto: List<Produto>?, val context: Context):
    RecyclerView.Adapter<VenderHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VenderHolder {
        return VenderHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_vender,parent,false)
        )
    }
    override fun onBindViewHolder(holder: VenderHolder, position: Int) {

        holder.nomeProd.text = produto!![position].nomeProd
        holder.preco.text = "R$${produto!![position].preco.toString()}"




    }

    override fun getItemCount(): Int {
        return produto?.size ?: 0
    }


}