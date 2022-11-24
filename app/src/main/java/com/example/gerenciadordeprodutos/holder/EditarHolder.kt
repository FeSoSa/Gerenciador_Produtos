package com.example.gerenciadordeprodutos.holder

import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gerenciadordeprodutos.R

class EditarHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var nomeProd: TextView
    var btnEditar: ImageButton
    var btnDelete: ImageButton

    init {
        nomeProd = itemView.findViewById(R.id.NomeProd)
        btnEditar = itemView.findViewById(R.id.editar)
        btnDelete = itemView.findViewById(R.id.deletar)
    }
}