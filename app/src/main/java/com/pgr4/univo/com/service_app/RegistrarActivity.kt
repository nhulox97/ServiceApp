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
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class RegistrarActivity : AppCompatActivity() {

    private lateinit var txtNombre:EditText
    private lateinit var txtApellido:EditText
    private lateinit var txtEdad:EditText
    private lateinit var txtEmail:EditText
    private lateinit var txtContraseña:EditText
    private lateinit var progressBar: ProgressBar
    private lateinit var dbReference:DatabaseReference
    private lateinit var database:FirebaseDatabase
    private lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)

        txtNombre=findViewById(R.id.txtNombre)
        txtApellido=findViewById(R.id.txtApellido)
        txtEdad=findViewById(R.id.txtEdad)
        txtEmail=findViewById(R.id.txtEmail)
        txtContraseña=findViewById(R.id.txtContraseña)

        progressBar=findViewById(R.id.progressBar)

        database=FirebaseDatabase.getInstance()
        auth=FirebaseAuth.getInstance()

        dbReference=database.reference.child("Usuarios")
    }

    fun Registrar(view: View) {
        CrearNuevaCuenta()
    }

    private fun CrearNuevaCuenta(){
        val nombre:String=txtNombre.text.toString()
        val apellido:String=txtApellido.text.toString()
        val edad:String=txtEdad.text.toString()
        val email:String=txtEmail.text.toString()
        val contraseña:String=txtContraseña.text.toString()

        progressBar.visibility = View.VISIBLE
        if(!TextUtils.isEmpty(nombre) && !TextUtils.isEmpty(apellido) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(contraseña) && !TextUtils.isEmpty(edad)){
            if(edad.toInt() < 18){
                Toast.makeText(this,"No se puede ser menor de edad",Toast.LENGTH_LONG).show()
                progressBar.visibility = View.GONE
            }else {
                auth.createUserWithEmailAndPassword(email, contraseña).addOnCompleteListener(this) { task ->

                    if (task.isSuccessful) {
                        val usuario: FirebaseUser? = auth.currentUser
                        VerificarEmail(usuario)

                        val usuarioBD = dbReference.child(usuario?.uid!!)

                        usuarioBD.child("Nombre").setValue(nombre)
                        usuarioBD.child("Apellido").setValue(apellido)
                        usuarioBD.child("Edad").setValue(edad)
                        Toast.makeText(this, "Cuenta creada satisfactoriamente", Toast.LENGTH_LONG).show()
                        Accion()
                    }else{
                        Toast.makeText(this, "La contraseña debe tener 6 caracteres como mínimo o error en el correo", Toast.LENGTH_LONG).show()
                        progressBar.visibility=View.GONE
                    }
                }
            }
        }else{
            Toast.makeText(this,"No debe dejar campos vacios",Toast.LENGTH_LONG).show()
            progressBar.visibility=View.GONE
        }
    }

    private fun Accion(){
        startActivity(Intent(this,LoginActivity::class.java))
    }



    private fun VerificarEmail(usuario:FirebaseUser?){
        usuario?.sendEmailVerification()?.addOnCompleteListener(this){
            task ->
            if(task.isSuccessful){
                Toast.makeText(this,"Correo Enviado",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"Error al enviar el correo",Toast.LENGTH_SHORT).show()
            }
        }
    }
}

