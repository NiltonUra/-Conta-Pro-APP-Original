package com.nsolucoes.contaproapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.nsolucoes.contaproapp.data.UserRepository
import com.nsolucoes.contaproapp.data.database.AppDatabase
import com.nsolucoes.contaproapp.data.database.entities.Receita
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ReceitaViewModel(application: Application) : AndroidViewModel(application) {

    val receitas: LiveData<List<Receita>>
    private val repository: UserRepository

    init {
        val dao = AppDatabase.getDatabase(application).userDao()
        repository = UserRepository(dao)
        receitas = repository.allReceitas
    }

    fun addReceita(receita: Receita) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addReceita(receita)
        }
    }

}