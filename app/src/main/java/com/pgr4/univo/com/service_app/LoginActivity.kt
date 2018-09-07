package com.pgr4.univo.com.service_app

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginActivity : AppCompatActivity() {

    private lateinit var txtUsuario: EditText
    private lateinit var txtContraseña: EditText
    private lateinit var progressBar: ProgressBar
    private lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        txtUsuario=findViewById(R.id.txtUsuario)
        txtContraseña=findViewById(R.id.txtContraseña)

        progressBar=findViewById(R.id.progressBar)
        auth= FirebaseAuth.getInstance()
        val usuario: FirebaseUser? = auth.currentUser
        VerificarEmail(usuario)

    }

    private fun VerificarEmail(usuario: FirebaseUser?){
        usuario?.sendEmailVerification()?.addOnCompleteListener(this){
            task ->
            if(task.isSuccessful){
                Toast.makeText(this,"Sesion iniciada", Toast.LENGTH_LONG).show()
                Accion()
            }else{
            }
        }
    }

    fun RecuperarContraseña(view: View){
        startActivity(Intent(this,RecuperarContrasenaActivity::class.java))
    }

    fun Registrar(view: View){
        startActivity(Intent(this,RegistrarActivity::class.java))
    }

    fun Login(view: View){
        LoginUsuario()
    }

    private fun LoginUsuario(){
        val usuario:String=txtUsuario.text.toString()
        val contraseña:String=txtContraseña.text.toString()

        progressBar.visibility=View.VISIBLE

        if(!TextUtils.isEmpty(usuario) && !TextUtils.isEmpty(contraseña)){

            auth.signInWithEmailAndPassword(usuario,contraseña).addOnCompleteListener(this){
                task ->
                if (task.isSuccessful){
                    Accion()
                }else{
                    progressBar.visibility=View.GONE
                    Toast.makeText(this,"Error al iniciar sesion", Toast.LENGTH_LONG).show()
                }
            }
        }else{
            progressBar.visibility=View.GONE
            Toast.makeText(this,"No puede dejar campos vacíos", Toast.LENGTH_LONG).show()
        }
    }

    private fun Accion(){
        startActivity(Intent(this,menu_principal::class.java))
    }

}
