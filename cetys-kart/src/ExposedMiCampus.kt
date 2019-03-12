package mx.cetys.arambula.angel

import mx.cetys.arambula.angel.exposed.callBuscarAlumnoSP

fun main(args: Array<String>) {
    val user = "021204"
    val password = "123456"
    val result = callBuscarAlumnoSP(user, password)

    result.forEach {
        print(it.matricula)
    }

}


