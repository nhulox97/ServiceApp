package com.pgr4.univo.com.service_app

class Perfil {

    var Nombre:String?=null
    var Apellido:String?=null
    var Edad:String?=null

    constructor(){
    }

    constructor(Nombre: String?, Apellido: String?, Edad: String?) {
        this.Nombre = Nombre
        this.Apellido = Apellido
        this.Edad = Edad
    }
}