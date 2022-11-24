package com.example.gerenciadordeprodutos.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.gerenciadordeprodutos.Produto
import com.example.gerenciadordeprodutos.R
import com.example.gerenciadordeprodutos.database.SQLiteHelper
import com.example.gerenciadordeprodutos.database.produtoDAO
import com.marcoscg.currencyedittext.CurrencyEditText

private  lateinit var edtNome: EditText
private lateinit var edtQuantidade:EditText
private lateinit var edtPreco:CurrencyEditText
private lateinit var btnAdicionar: Button

private lateinit var sqLiteHelper: SQLiteHelper

class adicionar : AppCompatActivity() {
    var operacao : String? = null
    var pessoa : Produto? = null
    var sucesso: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adicionar)

        val intent = intent
        val bundle = intent.getBundleExtra("pessoaProduto")
        pessoa= bundle!!.getSerializable("pessoa") as Produto?
        operacao = intent.getStringExtra("operacao")
        initView()

        if (operacao.equals("UPDATE")){
            edtNome.setText(pessoa?.nomeProd)
            edtQuantidade.setText(pessoa?.quantidade.toString())
            edtPreco.setText(pessoa?.preco.toString())
        }

        val btnSair: Button = findViewById(R.id.btnSair)
        btnSair.setOnClickListener {
            finish()
        }

        btnAdicionar.setOnClickListener{
            if (edtNome.text.toString().isEmpty()){
                Toast.makeText(applicationContext,"O Nome não pode ficar vazio",Toast.LENGTH_SHORT).show()
                } else if (edtQuantidade.text.toString().isEmpty()) {
                    Toast.makeText(applicationContext,"A Quantidade não pode ficar vazia!",Toast.LENGTH_SHORT).show()
                }else if (edtPreco.text.toString().isEmpty()) {
                Toast.makeText(applicationContext,"O Preço não pode ficar vazio!",Toast.LENGTH_SHORT).show()
            }else {
                val nomeProd = edtNome.text.toString()
                val quantidade = edtQuantidade.text.toString().toInt()
                val preco = edtPreco.getNumericValue().toDouble()

                val dao = produtoDAO(baseContext)
                if (operacao.equals("INSERT")){
                    sucesso = dao.salvar(nomeProd,quantidade,preco)
                } else if (operacao.equals("UPDATE")){
                    sucesso = dao.salvar(pessoa!!.id,nomeProd,quantidade,preco)
                }
                if (sucesso) {
                    if (operacao.equals("INSERT")){
                        edtNome.setText("")
                        edtQuantidade.setText("")
                        edtPreco.setText("$0.00")
                    }
                    edtNome.requestFocus()
                    Toast.makeText(applicationContext,"Produto Adicionado!",Toast.LENGTH_SHORT).show()
                }else {
                    Toast.makeText(applicationContext,"Falha ao adicionar produto!",Toast.LENGTH_SHORT).show()
                }
            }
        }
}
    private fun initView() {
        edtNome = findViewById(R.id.NomeProd)
        edtQuantidade = findViewById(R.id.quantidade)
        edtPreco = findViewById(R.id.preco)
        btnAdicionar = findViewById(R.id.add)
    }
}