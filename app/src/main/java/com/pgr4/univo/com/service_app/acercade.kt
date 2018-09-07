package com.pgr4.univo.com.service_app

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_acercade.*
import kotlinx.android.synthetic.main.categorias.*

class acercade : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acercade)

        btn_inicio5.setOnClickListener {
            var intent = Intent(this@acercade, menu_principal::class.java)
            startActivity(intent)
            finish()

        }

        btn_categorias5.setOnClickListener {
            var intent = Intent(this@acercade, activity_categorias::class.java)
            startActivity(intent)
            finish()

        }

        btn_contrataciones5.setOnClickListener {
            var intent = Intent(this@acercade, contrataciones::class.java)
            startActivity(intent)
            finish()

        }

        btn_favorito5.setOnClickListener {
            var intent = Intent(this@acercade, favorito::class.java)
            startActivity(intent)
            finish()


        }

        btn_acercade5.setOnClickListener {
            var intent = Intent(this@acercade, acercade::class.java)
            startActivity(intent)
            finish()

        }
    }
}
