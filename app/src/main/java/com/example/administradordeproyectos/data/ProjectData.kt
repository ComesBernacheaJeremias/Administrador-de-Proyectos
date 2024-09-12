package com.example.administradordeproyectos.data

import androidx.compose.runtime.mutableStateOf


 class tiposDeEstados(){
    val pending = "Pending"
    val comingSoon = "Coming Soon"
    val workInProgress = "Work in Progress"
    val review = "Review"
    val released = "Released"

}



class ProjectData (){
     val users = mutableListOf<String>()
     var estado = ""
     var name = ""
     var startDate = ""
     var dueDate = ""

     fun addUser(user: String) {
        users.add(user)
    }

     fun stateChange(state: tiposDeEstados) {
        estado = state.toString()
    }

     fun asignarNombre(nombre: String) {
        name = nombre
    }

     fun newStartDate(date: String) {
        startDate = date
    }

     fun newDueDate(date: String) {
        dueDate = date
    }
}