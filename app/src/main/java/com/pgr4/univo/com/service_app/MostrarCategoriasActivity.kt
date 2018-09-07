package com.pgr4.univo.com.service_app

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.NonNull
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.LinearLayout
import android.widget.Toast
//import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.google.firebase.database.*
import com.pgr4.univo.com.service_app.R.*
//import com.pgr4.univo.com.service_app.R.id.button
import kotlinx.android.synthetic.main.activity_mostrar_categorias.*
import kotlinx.android.synthetic.main.recycler_layout.*
import kotlinx.android.synthetic.main.recycler_layout.view.*

class MostrarCategoriasActivity : AppCompatActivity() {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mDataBase: DatabaseReference
    lateinit var trabajadorList : MutableList<Trabajadores>
    lateinit var lisView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_mostrar_categorias)

        /*val mensaje = intent.getStringExtra(PrincipalActivity.MENSAJE_ID)
        var mensajeTexto = mensaje*/

        //mDataBase.addValueEventListener{new ValueEventListener()}

        mRecyclerView = findViewById(R.id.recyclerView)
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        //mDataBase = FirebaseDatabase.getInstance().getReference("Trabajadores").child(mensajeTexto)
        trabajadorList = mutableListOf()
        //lisView=findViewById(R.id.recyclerView)

        val mensaje = intent.getStringExtra(PrincipalActivity.MENSAJE_ID)
        var mensajeTexto = mensaje
        mDataBase = FirebaseDatabase.getInstance().getReference("Trabajadores").child(mensajeTexto)

        mDataBase.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot) {
                if (p0.exists()) {
                    trabajadorList.clear()
                    for (e in p0.children) {
                        val gth = e.getValue(Trabajadores::class.java)
                        trabajadorList.add(gth!!)
                    }
                    val adapter = Adaptador(trabajadorList as ArrayList<Trabajadores>)
                    mRecyclerView.adapter = adapter
                }
            }
        })


       /* var adapter = Adaptador(generadorData())
        mRecyclerView.layoutManager=LinearLayoutManager(applicationContext)
        mRecyclerView.itemAnimator=DefaultItemAnimator()
        mRecyclerView.adapter=adapter
        adapter.notifyDataSetChanged()*/
    }
    companion object {
        val Mensaje_Nombre:String="ID_N"
        val Mensaje_Apellido:String="ID_A"
        val Mensaje_Profesion:String="ID_P"
        val Mensaje_Salario:String="ID_S"
    }

    fun Contratar(view: View){
        val nombre:String=txtNombre.text.toString()
        val apellido:String=txtApellido.text.toString()
        val profesion:String=txtProfesion.text.toString()
        val salario:String=txtSalario.text.toString()

        startActivity(Intent(this,FacturacionActivity::class.java).putExtra(Mensaje_Nombre,nombre)
                .putExtra(Mensaje_Apellido,apellido).putExtra(Mensaje_Profesion,profesion).putExtra(Mensaje_Salario,salario))
    }

    private fun generadorData():ArrayList<Trabajadores>{
        var result = ArrayList<Trabajadores>()

        for (i in 0..5) {
            val nombre = mDataBase.child("  Nombre")
            val apellido = mDataBase.child("  Apellido")
            val profesion = mDataBase.child("  Profesion")
            val salario = mDataBase.child("  SalarioPorHora")
            val popularidad = mDataBase.child("  Popularidad")
            val trabajador: Trabajadores = Trabajadores(nombre.toString(),apellido.toString(), profesion.toString(), salario.toString(), popularidad.toString())
            result.add(trabajador)
        }

        return result
    }
}


