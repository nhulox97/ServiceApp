package com.pgr4.univo.com.service_app

import android.app.DatePickerDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.*

class FacturacionActivity : AppCompatActivity(), View.OnClickListener {


    private lateinit var txtNumeroCuenta:EditText
    private lateinit var txtFecha:EditText
    private lateinit var txtCvv:EditText
    private lateinit var txtDireccion:EditText
    private lateinit var progressBar:ProgressBar
    private lateinit var dbReference: DatabaseReference
    private lateinit var database: FirebaseDatabase
    private lateinit var auth: FirebaseAuth
    private var dia:Int = 0
    private var mes:Int = 0
    private var ano:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facturacion)

        txtNumeroCuenta=findViewById(R.id.txtNumeroCuenta)
        txtFecha=findViewById(R.id.txtFecha)
        txtCvv=findViewById(R.id.txtCvv)
        txtDireccion=findViewById(R.id.txtDireccion)
        progressBar=findViewById(R.id.progressBar)

        //database=FirebaseDatabase.getInstance()
        auth=FirebaseAuth.getInstance()
        //dbReference=database.reference.child("Factura")
        txtFecha.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val calendario = Calendar.getInstance()
        val dia = calendario.get(Calendar.DAY_OF_MONTH)
        val mes = calendario.get(Calendar.MONTH)
        val ano = calendario.get(Calendar.YEAR)

        val dpd = DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            txtFecha.setText(""+dayOfMonth+"-"+month+"-"+year)
        },dia,mes,ano)

        dpd.show()
    }

    fun Siguiente(view: View){
        Siguientes()
    }

    companion object {
        val Mensaje_N:String="ID_Nombre"
        val Mensaje_A:String="ID_Apellido"
        val Mensaje_P:String="ID_Profesion"
        val Mensaje_S:String="ID_Salario"
        val Mensaje_NumeroCuenta:String="ID_NC"
        val Mensaje_Fecha:String="ID_F"
        val Mensaje_Cvv:String="ID_C"
        val Mensaje_Direccion:String="ID_D"
    }

    fun Siguientes(){
        val numeroCuenta:String=txtNumeroCuenta.text.toString()
        val fecha:String=txtFecha.text.toString()
        val cvv:String=txtCvv.text.toString()
        val direccion:String=txtDireccion.text.toString()
        progressBar.visibility=View.VISIBLE

        if(!TextUtils.isEmpty(numeroCuenta) && !TextUtils.isEmpty(fecha) && !TextUtils.isEmpty(cvv) && !TextUtils.isEmpty(direccion)){

            val nombre:String=intent.getStringExtra(MostrarCategoriasActivity.Mensaje_Nombre)
            var mensajeNombre:String=nombre
            val apellido:String=intent.getStringExtra(MostrarCategoriasActivity.Mensaje_Apellido)
            var mensajeApellido:String=apellido
            val profesion:String=intent.getStringExtra(MostrarCategoriasActivity.Mensaje_Profesion)
            var mensajeProfesion:String=profesion
            val salario:String=intent.getStringExtra(MostrarCategoriasActivity.Mensaje_Salario)
            var mensajeSalario:String=salario

            startActivity(Intent(this,PagoFacturaActivity::class.java).putExtra(Mensaje_N,mensajeNombre)
                    .putExtra(Mensaje_A,mensajeApellido).putExtra(Mensaje_P,mensajeProfesion).putExtra(Mensaje_S,mensajeSalario)
                    .putExtra(Mensaje_NumeroCuenta,numeroCuenta).putExtra(Mensaje_Fecha,fecha).putExtra(Mensaje_Cvv,cvv)
                    .putExtra(Mensaje_Direccion,direccion))
            /*val Facturas = dbReference.push()

            Facturas.child("NumeroCuenta").setValue(numeroCuenta)
            Facturas.child("Fecha").setValue(fecha)
            Facturas.child("CVV").setValue(cvv)
            Facturas.child("Direccion").setValue(direccion)
            Accion()*/
        }else{
            progressBar.visibility=View.GONE
            Toast.makeText(this,"No debe dejar campos vacios", Toast.LENGTH_SHORT).show()
        }
    }

    /*fun Accion(){
        startActivity(Intent(this,PagoFacturaActivity::class.java))
    }*/
}
