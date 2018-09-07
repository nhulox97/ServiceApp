package com.pgr4.univo.com.service_app

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_contrataciones.*
import kotlinx.android.synthetic.main.categorias.*

class contrataciones : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contrataciones)

        btn_inicio3.setOnClickListener {
            var intent = Intent(this@contrataciones, menu_principal::class.java)
            startActivity(intent)
            finish()

        }

        btn_categorias3.setOnClickListener {
            var intent = Intent(this@contrataciones, activity_categorias::class.java)
            startActivity(intent)
            finish()

        }

        btn_contrataciones3.setOnClickListener {
            var intent = Intent(this@contrataciones, contrataciones::class.java)
            startActivity(intent)
            finish()

        }

        btn_favorito3.setOnClickListener {
            var intent = Intent(this@contrataciones, favorito::class.java)
            startActivity(intent)
            finish()

        }

        btn_acercade3.setOnClickListener {
            var intent = Intent(this@contrataciones, acercade::class.java)
            startActivity(intent)
            finish()

        }
    }
}
