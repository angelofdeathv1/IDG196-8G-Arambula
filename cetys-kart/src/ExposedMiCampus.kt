package mx.cetys.arambula.angel

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction
import java.sql.ResultSet

fun main(args: Array<String>) {
    Database.connect(
        "jdbc:sqlserver://mi-campus.cnlbrz9mbb74.us-east-2.rds.amazonaws.com\\mi-campus:1433;database=MICAMPUS",
        "com.microsoft.sqlserver.jdbc.SQLServerDriver",
        user = "micampus",
        password = "password1234"
    )
    transaction {
        // print sql to std-out
        addLogger(StdOutSqlLogger)

        val test = "SELECT * FROM MICAMPUS.dbo.Alumno".execAndMap { rs ->
            rs.getString("Matricula") to rs.getString("Nombre_1")
        }

//        val user = "021204"
//        val password = "1234)"
//        val test1 = "exec dbo.buscar_alumno('$user','$password')".execAndMap { rs ->
//            rs.getString("Matricula") to rs.getString("Matricula")
//        }


        println(test)
    }
}

fun <T : Any> String.execAndMap(transform: (ResultSet) -> T): List<T> {
    val result = arrayListOf<T>()
    TransactionManager.current().exec(this) { rs ->
        while (rs.next()) {
            result += transform(rs)
        }
    }
    return result
}