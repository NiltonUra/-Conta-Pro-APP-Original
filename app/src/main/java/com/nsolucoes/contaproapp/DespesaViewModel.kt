package com.nsolucoes.contaproapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.nsolucoes.contaproapp.data.UserRepository
import com.nsolucoes.contaproapp.data.database.UserDatabase
import com.nsolucoes.contaproapp.data.database.entities.Despesa
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DespesaViewModel(application: Application) : AndroidViewModel(application) {

    val despesas: LiveData<List<Despesa>>
    private val repository: UserRepository

    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        despesas = repository.allDespesas
    }

    fun addDespesa(despesa: Despesa) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addDespesa(despesa)
        }
    }

    /*private var listaDespesas = mutableListOf<Despesa>()
    fun addDespesa(despesa: Despesa) {
        listaDespesas.add(despesa)
        _despesas.value = listaDespesas
    }*/

}