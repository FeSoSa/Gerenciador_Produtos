package com.example.gerenciadordeprodutos.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gerenciadordeprodutos.R
import com.example.gerenciadordeprodutos.adapter.AdapterProduto
import com.example.gerenciadordeprodutos.database.produtoDAO
import com.google.android.material.floatingactionbutton.FloatingActionButton

class produtos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produtos)
        val carrinho=findViewById<FloatingActionButton>(R.id.carrinho)
        carrinho.setOnClickListener{
        val vender= Intent(this,vender::class.java)
            startActivity(vender)
    }}


    private fun configurarRecycler() {
        // Configurando o gerenciador de layout para ser uma lista.
        val recyclerView: RecyclerView = findViewById(R.id.listaProd)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.setLayoutManager(layoutManager)

        // Adiciona o adapter que irá anexar os objetos à lista.
        val dao = produtoDAO(this)
        val adapter = AdapterProduto(dao.retornarTodos(), this)
        recyclerView.setAdapter(adapter)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }

    override fun onStart() {
        super.onStart()
        configurarRecycler()
    }
}