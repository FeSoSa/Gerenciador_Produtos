package com.example.gerenciadordeprodutos.holder

import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gerenciadordeprodutos.Produto
import com.example.gerenciadordeprodutos.R

class VenderHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var nomeProd: TextView
    var deleteProduto: ImageButton
    var preco: TextView
    var qntItem: Spinner

    init {
        nomeProd = itemView.findViewById(R.id.NomeProd)
        preco = itemView.findViewById(R.id.preco)
        deleteProduto = itemView.findViewById(R.id.deletarProduto)
        qntItem = itemView.findViewById(R.id.quantidadeItem)

    }
}