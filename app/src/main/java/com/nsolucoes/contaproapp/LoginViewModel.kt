package com.nsolucoes.contaproapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.nsolucoes.contaproapp.data.database.UserDatabase
import com.nsolucoes.contaproapp.data.UserRepository
import com.nsolucoes.contaproapp.data.database.entities.Usuario
import kotlinx.coroutines.launch

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: UserRepository

    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
    }

    fun getUserByEmail(email: String): LiveData<Usuario?> {
        var _usuario = MutableLiveData<Usuario>()
        viewModelScope.launch {
            repository.getUserByEmail(email).collect {
                _usuario.value = it
            }
        }
        return _usuario
    }

}