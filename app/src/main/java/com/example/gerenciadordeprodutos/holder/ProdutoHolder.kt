package com.example.gerenciadordeprodutos.holder

import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gerenciadordeprodutos.R

class ProdutoHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var nomeProd: TextView
    var preco: TextView
    var quantidade: TextView

    init {
        nomeProd = itemView.findViewById(R.id.NomeProd)
        preco = itemView.findViewById(R.id.preco)
        quantidade = itemView.findViewById(R.id.quantidade)
    }
}