package com.nsolucoes.contaproapp.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "despesa_table")
class Despesa(
    @PrimaryKey (autoGenerate = true)
    val id: Long,
    val tipo: String,
    val valor: Double,
    val dataHora: String,
)