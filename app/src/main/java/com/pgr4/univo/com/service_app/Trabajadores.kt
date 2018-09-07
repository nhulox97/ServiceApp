package com.pgr4.univo.com.service_app

class Trabajadores {

    var Nombre:String?=null
    var Apellido:String?=null
    var Profesion:String?=null
    var SalarioPorHora:String?=null
    var Popularidad:String?=null

    constructor(){

    }

    constructor(Nombre: String?, Apellido: String?, Profesion: String?, SalarioPorHora: String?, Popularidad: String?) {
        this.Nombre = Nombre
        this.Apellido = Apellido
        this.Profesion = Profesion
        this.SalarioPorHora = SalarioPorHora
        this.Popularidad = Popularidad
    }

}