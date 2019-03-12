package mx.cetys.arambula.angel.exposed

import mx.cetys.arambula.angel.AlumnoDTO
import mx.cetys.arambula.angel.execSp
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction

fun callBuscarAlumnoSP(user: String, password: String): List<AlumnoDTO> {
    val storedProcedureRawSQL = "exec dbo.buscar_alumno '$user','$password'"
    val resultList = ArrayList<AlumnoDTO>()

    Database.connect(
        EXPOSED_CONNECTION_STRING,
        EXPOSED_DRIVER,
        EXPOSED_USER,
        EXPOSED_PASSWORD
    )

    transaction {
        execSp(storedProcedureRawSQL) {
            while (it.next()) {
                resultList.add(AlumnoDTO(it.getString("Matricula")))
            }
        }
    }
    return resultList
}