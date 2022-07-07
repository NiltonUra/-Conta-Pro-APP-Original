package com.nsolucoes.contaproapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nsolucoes.contaproapp.data.database.entities.Despesa
import com.nsolucoes.contaproapp.data.database.entities.Usuario
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    //Anotação para inserir e ignorar dados duplicados
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addUser(usuario: Usuario)

    //Selecionar usuarios
    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun selectUsers(): LiveData<List<Usuario>>

    @Query("SELECT * FROM user_table WHERE email = :email")
    fun getUserByEmail(email: String): Flow<Usuario?>


    //Inserir Despesa
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addDespesa(despesa: Despesa)

    //Pegar Despesas
    @Query("SELECT * FROM despesa_table")
    fun getAllDespesas(): LiveData<List<Despesa>>
}