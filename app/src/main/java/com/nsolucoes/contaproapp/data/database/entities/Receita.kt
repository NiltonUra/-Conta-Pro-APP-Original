package com.nsolucoes.contaproapp.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "receita_table")
class Receita(
    @PrimaryKey (autoGenerate = true)
    val id: Long,
    val tipo: String,
    val valor: Double,
    val dataHora: String,
)