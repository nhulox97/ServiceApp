package com.pgr4.univo.com.service_app

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.firebase.auth.FirebaseAuth

class splash_screen : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    val SPLAHS_TIME = 1500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed(object : Runnable {
            override fun run(){
                loggedUser()
                finish()
            }

        }, SPLAHS_TIME.toLong())

    }
    fun loggedUser(){
        auth = FirebaseAuth.getInstance()
        val user = auth.currentUser
        if(user != null){
            logged()
        }
        else{
            login()
        }

    }
    fun login(){
        startActivity(Intent(this, LoginActivity::class.java))
    }
    fun logged(){
        startActivity(Intent(this, menu_principal::class.java))
    }
}
