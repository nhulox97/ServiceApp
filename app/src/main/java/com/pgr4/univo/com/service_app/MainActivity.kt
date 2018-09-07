package com.pgr4.univo.com.service_app

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import java.security.Principal

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startActivity(Intent(this,LoginActivity::class.java))


    }


}
