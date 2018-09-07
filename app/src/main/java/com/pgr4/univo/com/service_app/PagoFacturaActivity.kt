package com.pgr4.univo.com.service_app

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_pago_factura.*

class PagoFacturaActivity : AppCompatActivity() {

    private lateinit var txtNumeroCuenta:TextView
    private lateinit var txtFecha:TextView
    private lateinit var txtCVV:TextView
    private lateinit var txtDireccion:TextView
    private lateinit var txtServicios:TextView
    private lateinit var txtSalario:TextView
    private lateinit var txtNombres:TextView
    private lateinit var txtApellidos:TextView
    private lateinit var progressBar:ProgressBar
    private lateinit var dbReference: DatabaseReference
    private lateinit var database: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pago_factura)


        txtNumeroCuenta=findViewById(R.id.txtNumeroCuenta)
        txtFecha=findViewById(R.id.txtFechaVencimiento)
        txtCVV=findViewById(R.id.txtCvv)
        txtDireccion=findViewById(R.id.txtDireccion)
        txtServicios=findViewById(R.id.txtServicio)
        txtSalario=findViewById(R.id.txtSalario)
        txtNombres=findViewById(R.id.txtNombres)
        txtApellidos=findViewById(R.id.txtApellidos)
        progressBar=findViewById(R.id.progressBar3)

        database = FirebaseDatabase.getInstance()
        dbReference = database.reference.child("Factura")

        val numeroCuenta:String=intent.getStringExtra(FacturacionActivity.Mensaje_NumeroCuenta)
        var mensajeNumeroCuenta:String=numeroCuenta
        txtNumeroCuenta.text=mensajeNumeroCuenta
        val fecha:String=intent.getStringExtra(FacturacionActivity.Mensaje_Fecha)
        var mensajeFecha:String=fecha
        txtFecha.text=mensajeFecha
        val cvv:String=intent.getStringExtra(FacturacionActivity.Mensaje_Cvv)
        var mensajeCvv:String=cvv
        txtCVV.text=mensajeCvv
        val direccion:String=intent.getStringExtra(FacturacionActivity.Mensaje_Direccion)
        var mensajeDireccion:String=direccion
        txtDireccion.text=mensajeDireccion
        val servicios:String=intent.getStringExtra(FacturacionActivity.Mensaje_P)
        var mensajeServicios:String=servicios
        txtServicios.text=mensajeServicios
        val salario:String=intent.getStringExtra(FacturacionActivity.Mensaje_S)
        var mensajeSalario:String=salario
        txtSalario.text=mensajeSalario
        val nombres:String=intent.getStringExtra(FacturacionActivity.Mensaje_N)
        var mensajeNombres:String=nombres
        txtNombres.text=mensajeNombres
        val apellidos:String=intent.getStringExtra(FacturacionActivity.Mensaje_A)
        var mensajeApellidos:String=apellidos
        txtApellidos.text=mensajeApellidos
    }

    fun Aceptar(view:View){
        Toast.makeText(this,"Transacción exitosa",Toast.LENGTH_LONG).show()
        startActivity(Intent(this,menu_principal::class.java))
        Aceptara()
    }

    private fun Aceptara(){
        progressBar.visibility=View.VISIBLE
        val numeroCuenta:String=txtNumeroCuenta.text.toString()
        val fecha:String=txtFecha.text.toString()
        val cvv:String=txtCVV.text.toString()
        val direccion:String=txtDireccion.text.toString()
        val servicios:String=txtServicios.text.toString()
        val salario:String=txtSalario.text.toString()
        val nombres:String=txtNombres.text.toString()
        val apellidos:String=txtApellidos.text.toString()

        val facturas = dbReference.push()

        facturas.child("NumeroCuenta").setValue(numeroCuenta)
        facturas.child("FechaDeVencimiento").setValue(fecha)
        facturas.child("CVV").setValue(cvv)
        facturas.child("Direccion").setValue(direccion)
        facturas.child("ServicioContratado").setValue(servicios)
        facturas.child("Salario").setValue(salario)
        facturas.child("NombresDelTrabajador").setValue(nombres)
        facturas.child("ApellidosDelTrabajador").setValue(apellidos)

    }

    fun PaginaPrincipal(view: View){
        progressBar.visibility= View.VISIBLE
        startActivity(Intent(this,menu_principal::class.java))
    }
}
