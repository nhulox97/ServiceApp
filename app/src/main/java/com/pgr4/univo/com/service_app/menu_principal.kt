package com.pgr4.univo.com.service_app

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu_principal.*

class menu_principal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal)

        btn_inicio.setOnClickListener {
            var intent = Intent(this@menu_principal, menu_principal::class.java)
            startActivity(intent)
            finish()
        }

        btn_categorias.setOnClickListener {
            var intent = Intent(this@menu_principal, activity_categorias::class.java)
            startActivity(intent)
            finish()

        }

        btn_contrataciones.setOnClickListener {
            var intent = Intent(this@menu_principal, contrataciones::class.java)
            startActivity(intent)
            finish()

        }

        btn_favorito.setOnClickListener {
            var intent = Intent(this@menu_principal, favorito::class.java)
            startActivity(intent)
            finish()

        }

        btn_acercade.setOnClickListener {
            var intent = Intent(this@menu_principal, acercade::class.java)
            startActivity(intent)
            finish()

        }
    }
}
