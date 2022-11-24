package com.example.gerenciadordeprodutos.adapter

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gerenciadordeprodutos.*
import com.example.gerenciadordeprodutos.holder.EditarHolder
import com.example.gerenciadordeprodutos.views.adicionar
import com.example.gerenciadordeprodutos.database.produtoDAO
import com.google.android.material.snackbar.Snackbar


class AdapterEditar (private val  produto: List<Produto>?,val context: Context):
    RecyclerView.Adapter<EditarHolder>(){

    fun removerPessoa(pessoa: Produto){
        val position = produto!!.indexOf(pessoa!!)
        produto.drop(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position,1)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EditarHolder {
        return EditarHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_editar, parent, false)
        )
    }


    override fun onBindViewHolder(holder: EditarHolder, position: Int) {
        holder.nomeProd.text = produto!![position].nomeProd

        val pessoa = produto[position]
        holder.btnDelete.setOnClickListener {
            val builder = AlertDialog.Builder(context)
            builder.setTitle("Confirmação")
                .setMessage("Tem certeza que deseja excluir este Produto?")
                .setPositiveButton("Excluir",
                    DialogInterface.OnClickListener { dialog, which ->
                        val dao = produtoDAO(context)
                        val sucesso = dao.excluir(pessoa.id)
                        if (sucesso) {
                            removerPessoa(pessoa)
                            holder.itemView.visibility = View.GONE
                            Snackbar.make(it, "Excluiu!", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show()
                        } else {
                            Snackbar.make(it, "Erro ao excluir o cliente!", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show()
                        }
                    })
                .setNegativeButton("Cancelar", null)
                .create()
                .show()
        }

        holder.btnEditar.setOnClickListener {
            val insercao = Intent(context, adicionar::class.java)
            val parametro = Bundle()
            parametro.putSerializable("pessoa", pessoa)
            insercao.putExtra("pessoaProduto", parametro)
            insercao.putExtra("operacao", "UPDATE")
            context.startActivity(insercao)
        }
    }

    override fun getItemCount(): Int {
        return produto?.size ?: 0
    }
}

