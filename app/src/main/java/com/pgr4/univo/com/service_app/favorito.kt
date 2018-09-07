package com.pgr4.univo.com.service_app

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_favorito.*
import kotlinx.android.synthetic.main.categorias.*

class favorito : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorito)

        btn_inicio4.setOnClickListener {
            var intent = Intent(this@favorito, menu_principal::class.java)
            startActivity(intent)
            finish()

        }

        btn_categorias4.setOnClickListener {
            var intent = Intent(this@favorito, activity_categorias::class.java)
            startActivity(intent)
            finish()

        }

        btn_contrataciones4.setOnClickListener {
            var intent = Intent(this@favorito, contrataciones::class.java)
            startActivity(intent)
            finish()

        }

        btn_favorito4.setOnClickListener {
            var intent = Intent(this@favorito, favorito::class.java)
            startActivity(intent)
            finish()

        }

        btn_acercade4.setOnClickListener {
            var intent = Intent(this@favorito, acercade::class.java)
            startActivity(intent)
            finish()

        }
    }
}
