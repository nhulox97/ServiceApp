package com.pgr4.univo.com.service_app

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu_principal.*
import kotlinx.android.synthetic.main.categorias.*

class activity_categorias : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.categorias)

        btn_inicio2.setOnClickListener {
            var intent = Intent(this@activity_categorias, menu_principal::class.java)
            startActivity(intent)
            finish()

        }

        btn_categorias2.setOnClickListener {
            var intent = Intent(this@activity_categorias, activity_categorias::class.java)
            startActivity(intent)
            finish()

        }

        btn_contrataciones2.setOnClickListener {
            var intent = Intent(this@activity_categorias, contrataciones::class.java)
            startActivity(intent)
            finish()

        }

        btn_favorito2.setOnClickListener {
            var intent = Intent(this@activity_categorias, favorito::class.java)
            startActivity(intent)
            finish()

        }

        btn_acercade2.setOnClickListener {
            var intent = Intent(this@activity_categorias, acercade::class.java)
            startActivity(intent)
            finish()

        }

        btn_Automotriz.setOnClickListener{
            val mensaje: String = "AtencionAUtomotriz"
            startActivity(Intent(this, MostrarCategoriasActivity::class.java).putExtra(PrincipalActivity.MENSAJE_ID, mensaje))
        }

        btn_Hogar.setOnClickListener{
            val mensaje: String = "Hogar"
            startActivity(Intent(this, MostrarCategoriasActivity::class.java).putExtra(PrincipalActivity.MENSAJE_ID, mensaje))
        }

        btn_Profesional.setOnClickListener{
            val mensaje: String = "Profesional"
            startActivity(Intent(this, MostrarCategoriasActivity::class.java).putExtra(PrincipalActivity.MENSAJE_ID, mensaje))
        }

        btn_Tecnico.setOnClickListener{
            val mensaje: String = "ServciosTecnicos"
            startActivity(Intent(this, MostrarCategoriasActivity::class.java).putExtra(PrincipalActivity.MENSAJE_ID, mensaje))
        }


    }
}
