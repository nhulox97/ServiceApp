package com.pgr4.univo.com.service_app

import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.w3c.dom.Text

class Adaptador(var items:ArrayList<Trabajadores>) : RecyclerView.Adapter<Adaptador.TrabajadoresViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrabajadoresViewHolder {
        val itemView= LayoutInflater.from(parent?.context).inflate(R.layout.recycler_layout,parent,false)
        return TrabajadoresViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: TrabajadoresViewHolder, position: Int) {
        var Trabajadores = items[position]
        holder?.txtNombre?.text=Trabajadores.Nombre
        holder?.txtApellido?.text=Trabajadores.Apellido
        holder?.txtProfesion?.text=Trabajadores.Profesion
        holder?.txtSalario?.text=Trabajadores.SalarioPorHora
        holder?.txtPopularidad?.text=Trabajadores.Popularidad

    }

    class TrabajadoresViewHolder(row:View) : RecyclerView.ViewHolder(row) {
        var txtNombre : TextView? = null
        var txtApellido:TextView? = null
        var txtProfesion:TextView? = null
        var txtSalario:TextView?=null
        var txtPopularidad:TextView?=null

        init {
            this.txtNombre = row?.findViewById(R.id.txtNombre)
            this.txtApellido=row?.findViewById(R.id.txtApellido)
            this.txtProfesion=row?.findViewById(R.id.txtProfesion)
            this.txtSalario=row?.findViewById(R.id.txtSalario)
            this.txtPopularidad=row?.findViewById(R.id.txtPopularidad)
        }

    }
}