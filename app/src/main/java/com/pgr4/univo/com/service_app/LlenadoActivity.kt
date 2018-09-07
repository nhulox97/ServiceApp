package com.pgr4.univo.com.service_app

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
import com.google.firebase.database.ValueEventListener
import java.util.*

class LlenadoActivity : AppCompatActivity() {

    private lateinit var txtNombre:EditText
    private lateinit var txtApellido:EditText
    private lateinit var txtProfesion:EditText
    private lateinit var txtSalario:EditText
    private lateinit var txtPopularidad:EditText
    private lateinit var txtCategoria:EditText
    //private lateinit var txtID:EditText
    private lateinit var progressBar: ProgressBar
    private lateinit var dbReference: DatabaseReference
    private lateinit var database: FirebaseDatabase
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_llenado)

        txtNombre=findViewById(R.id.txtNombre)
        txtApellido=findViewById(R.id.txtApellido)
        txtProfesion=findViewById(R.id.txtProfesion)
        txtSalario=findViewById(R.id.txtSalario)
        txtPopularidad=findViewById(R.id.txtPopularidad)
        txtCategoria=findViewById(R.id.txtCategoria)
        //txtID=findViewById(R.id.txtID)

        progressBar=findViewById(R.id.progressBar)

        database=FirebaseDatabase.getInstance()
        auth=FirebaseAuth.getInstance()

        dbReference=database.reference.child("Trabajadores")
    }

    fun AgregarTrabajador(view: View){
        Agregar()
    }

    private fun Agregar(){
        val nombre:String=txtNombre.text.toString()
        val apellido:String=txtApellido.text.toString()
        val profesion:String=txtProfesion.text.toString()
        val salario:String=txtSalario.text.toString()
        val popularidad:String=txtPopularidad.text.toString()
        val categoria:String=txtCategoria.text.toString()
        //val iD:String=txtID.text.toString()

        if(!TextUtils.isEmpty(nombre) && !TextUtils.isEmpty(apellido) && !TextUtils.isEmpty(profesion) && !TextUtils.isEmpty(salario) && !TextUtils.isEmpty(popularidad) && !TextUtils.isEmpty(categoria) && popularidad.toInt() <= 10){
            progressBar.visibility=View.VISIBLE

            val trabajadorBD=dbReference.child(categoria).push()

            trabajadorBD.child("Nombre  ").setValue(nombre)
            trabajadorBD.child("Apellido  ").setValue(apellido)
            trabajadorBD.child("Profesion  ").setValue(profesion)
            trabajadorBD.child("SalarioPorHora  ").setValue(salario)
            trabajadorBD.child("Popularidad  ").setValue(popularidad)
            //trabajadorBD.child("Categoria").setValue(categoria)
        }else{
            Toast.makeText(this,"No debe dejar campos vacios",Toast.LENGTH_SHORT).show()
        }
    }
}
