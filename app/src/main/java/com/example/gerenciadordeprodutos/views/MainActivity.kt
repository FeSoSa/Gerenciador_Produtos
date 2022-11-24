package com.example.gerenciadordeprodutos.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.gerenciadordeprodutos.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnEditar:Button=findViewById(R.id.btnEditar)
        btnEditar.setOnClickListener{
            val editar= Intent(this, editar::class.java)
            startActivity(editar)
        }

        val btnProduto:Button=findViewById(R.id.btnProdutos)
        btnProduto.setOnClickListener{
            val produtos= Intent(this, produtos::class.java)
            startActivity(produtos)
        }



    }
}