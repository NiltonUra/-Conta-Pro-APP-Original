package com.nsolucoes.contaproapp.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
class Usuario(

    @PrimaryKey (autoGenerate = true)
    val id: Long,
    val nomeCompleto: String,
    val dataNascimento: String,
    val cpf: String,
    val cep: String,
    val estado: String,
    val cidade: String,
    //val logradouro: String,
    //val numero: Int,
    val bairro: String,
    val complemento: String,
    val email: String,
    val senha: String,
    val confirmarSenha: String

) {

}