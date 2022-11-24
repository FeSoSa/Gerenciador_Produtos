package com.example.gerenciadordeprodutos.database

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import com.example.gerenciadordeprodutos.Produto

class produtoDAO(ctx:Context?) {
    private  val TBL_PRODUTO = "tbl_produto"
    private  val gw: DbGateway?

    init {
        gw = DbGateway.getInstance(ctx!!)
    }

    fun salvar(nomeProd: String?, quantidade: Int , preco:Double): Boolean{
        return salvar(0,nomeProd,quantidade,preco)
    }

    fun salvar(id:Int, nomeProd: String?, quantidade: Int , preco: Double): Boolean {
        val cv = ContentValues()
        cv.put("NOMEPROD", nomeProd)
        cv.put("QUANTIDADE",quantidade)
        cv.put("PRECO",preco)
        return if (id!! > 0){
            gw!!.database.update(TBL_PRODUTO,cv,"ID=?", arrayOf(id.toString()+"")) > 0
        }else{
            gw!!.database.insert(TBL_PRODUTO,null,cv) > 0
        }
    }
    @SuppressLint("Range")
    fun retornarTodos():List<Produto>?{
        val produto:MutableList<Produto> = ArrayList()
        val sql = "SELECT ID,NOMEPROD,QUANTIDADE,PRECO FROM $TBL_PRODUTO ORDER BY nomeProd"
        val cursor:Cursor = gw!!.database.rawQuery(sql,null)
        while (cursor.moveToNext()){
            val id: Int = cursor.getInt(cursor.getColumnIndex("ID"))
            val nomeProd: String = cursor.getString(cursor.getColumnIndex("NOMEPROD"))
            val quantidade: Int = cursor.getInt(cursor.getColumnIndex("QUANTIDADE"))
            val preco: Double = cursor.getDouble(cursor.getColumnIndex("PRECO"))
            produto.add(Produto(id,nomeProd, quantidade, preco))
        }
        cursor.close()
        return produto
    }

    fun excluir(id: Int):Boolean{
        return gw!!.database.delete(TBL_PRODUTO,"ID=?"  , arrayOf(id.toString()+ ""))> 0
    }
}