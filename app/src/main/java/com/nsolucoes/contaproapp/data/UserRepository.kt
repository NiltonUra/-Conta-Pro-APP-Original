package com.nsolucoes.contaproapp.data

import com.nsolucoes.contaproapp.data.database.UserDao
import com.nsolucoes.contaproapp.data.database.entities.Despesa
import com.nsolucoes.contaproapp.data.database.entities.Usuario
import kotlinx.coroutines.flow.Flow

class UserRepository(private val dao: UserDao) {

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

}