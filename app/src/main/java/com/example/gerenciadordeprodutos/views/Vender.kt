package com.example.gerenciadordeprodutos.views

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gerenciadordeprodutos.R
import com.example.gerenciadordeprodutos.adapter.AdapterVender
import com.example.gerenciadordeprodutos.database.produtoDAO


class vender : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vender)

    }

    private fun configurarRecycler() {
        // Configurando o gerenciador de layout para ser uma lista.
        val recyclerView: RecyclerView = findViewById(R.id.listaVenda)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.setLayoutManager(layoutManager)

        // Adiciona o adapter que irá anexar os objetos à lista.
        val dao = produtoDAO(this)
        val adapter = AdapterVender(dao.retornarTodos(), this)
        recyclerView.setAdapter(adapter)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        val voltar = findViewById<Button>(R.id.voltar).setOnClickListener{
            finish()
        }

        val vender=findViewById<Button>(R.id.vender).setOnClickListener{
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Confirmação")
                .setMessage("Se clicar em Confirmar, os produtos serão retirados do estoque!")
                .setPositiveButton("Confirmar",
                    DialogInterface.OnClickListener { dialog, which ->
                    })
                .setNegativeButton("Cancelar", null)
                .setOnCancelListener(null)
                .create()
                .show()
        }

    }

    override fun onStart() {
        super.onStart()
        configurarRecycler()
    }
}