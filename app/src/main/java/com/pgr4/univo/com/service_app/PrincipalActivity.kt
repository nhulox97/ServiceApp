package com.pgr4.univo.com.service_app

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class PrincipalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
    }

    companion object {
        val MENSAJE_ID:String = "Identificador Hogar"
        //val MENSAJE_ID1:String = "Identificador Servicios Tecnivos"
        //val MENSAJE_ID2:String = "Identificador Profesional"
        //val MENSAJE_ID3:String = "Identificador Automotriz"
    }

    fun Hogar(view:View){
        val mensaje:String = "Hogar"
        startActivity(Intent(this,MostrarCategoriasActivity::class.java).putExtra(MENSAJE_ID,mensaje))
    }

    fun ServiciosTecnicos(view:View){
        val mensaje:String = "ServiciosTecnicos"
        startActivity(Intent(this,MostrarCategoriasActivity::class.java).putExtra(MENSAJE_ID,mensaje))
    }

    fun Profesional(view: View){
        val mensaje:String = "Profesional"
        startActivity(Intent(this,MostrarCategoriasActivity::class.java).putExtra(MENSAJE_ID,mensaje))
    }

    fun Automotriz(view: View){
        val mensaje:String = "AtencionAutomotriz"
        startActivity(Intent(this,MostrarCategoriasActivity::class.java).putExtra(MENSAJE_ID,mensaje))
    }
}
