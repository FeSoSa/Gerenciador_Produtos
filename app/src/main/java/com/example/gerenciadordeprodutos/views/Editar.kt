package com.example.gerenciadordeprodutos.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gerenciadordeprodutos.R
import com.example.gerenciadordeprodutos.adapter.AdapterEditar
import com.example.gerenciadordeprodutos.views.adicionar

import com.example.gerenciadordeprodutos.database.produtoDAO
import com.google.android.material.floatingactionbutton.FloatingActionButton

class editar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar)

        val novoProd: FloatingActionButton = findViewById(R.id.addProd)
        novoProd.setOnClickListener {
            val insercao = Intent(this@editar, adicionar::class.java)
            val parametro = Bundle()
            parametro.putSerializable("pessoa", null)
            insercao.putExtra("pessoaProduto", parametro)
            insercao.putExtra("operacao", "INSERT")
            startActivity(insercao)
        }
    }

    private fun configurarRecycler() {
        // Configurando o gerenciador de layout para ser uma lista.
        val recyclerView: RecyclerView = findViewById(R.id.listaEdit)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.setLayoutManager(layoutManager)

        // Adiciona o adapter que irá anexar os objetos à lista.
        val dao = produtoDAO(this)
        val adapter = AdapterEditar(dao.retornarTodos(), this)
        recyclerView.setAdapter(adapter)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }

    override fun onStart() {
        super.onStart()
        configurarRecycler()
    }

}
