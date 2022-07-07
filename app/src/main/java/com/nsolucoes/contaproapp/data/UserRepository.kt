package com.nsolucoes.contaproapp.data

import com.nsolucoes.contaproapp.data.database.MainDao
import com.nsolucoes.contaproapp.data.database.entities.Despesa
import com.nsolucoes.contaproapp.data.database.entities.Receita
import com.nsolucoes.contaproapp.data.database.entities.Usuario
import kotlinx.coroutines.flow.Flow

class UserRepository(private val dao: MainDao) {

    val selectUsers = dao.selectUsers()

    //Usuário
    fun addUser(usuario: Usuario){
        dao.addUser(usuario)
    }

    fun getUserByEmail(email: String): Flow<Usuario?>{
        return dao.getUserByEmail(email)
    }

    //Despesa
    fun addDespesa(despesa: Despesa){
        dao.addDespesa(despesa)
    }

    val allDespesas = dao.getAllDespesas()

    //Receitas
    fun addReceita(receita: Receita){
        dao.addDespesa(receita)
    }

    val allReceitas = dao.getAllReceitas()

}