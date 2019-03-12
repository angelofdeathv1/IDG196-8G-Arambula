package mx.cetys.arambula.angel

import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

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

        SchemaUtils.create(Cities)

        // insert new city. SQL: INSERT INTO Cities (name) VALUES ('St. Petersburg')
        val stPeteId = Cities.insert {
            it[name] = "St. Petersburg"
        } get Cities.id

        // 'select *' SQL: SELECT Cities.id, Cities.name FROM Cities
        println("Cities: ${Cities.selectAll()}")
    }
}

object Cities : IntIdTable() {
    val name = varchar("name", 50)
}