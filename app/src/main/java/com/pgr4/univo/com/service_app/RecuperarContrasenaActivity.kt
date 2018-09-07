package com.pgr4.univo.com.service_app

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.AbsListView
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RecuperarContrasenaActivity : AppCompatActivity() {

    private lateinit var txtEmail:EditText
    private lateinit var auth:FirebaseAuth
    private lateinit var progressBar:ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recuperar_contrasena)

        txtEmail=findViewById(R.id.txtEmail)
        auth= FirebaseAuth.getInstance()
        progressBar=findViewById(R.id.progressBar)
    }

    fun Enviar(view: View){
        val email:String=txtEmail.text.toString()

        if(!TextUtils.isEmpty(email)){
            auth.sendPasswordResetEmail(email).addOnCompleteListener(this){
                task ->
                if(task.isSuccessful){
                    progressBar.visibility=View.VISIBLE
                    startActivity(Intent(this,LoginActivity::class.java))
                }else{
                    progressBar.visibility=View.GONE
                    Toast.makeText(this,"Error al enviar el correo", Toast.LENGTH_SHORT).show()
                }
            }
        }else{
            progressBar.visibility=View.GONE
            Toast.makeText(this,"No debe dejar campos vacios", Toast.LENGTH_LONG).show()
        }
    }
}
