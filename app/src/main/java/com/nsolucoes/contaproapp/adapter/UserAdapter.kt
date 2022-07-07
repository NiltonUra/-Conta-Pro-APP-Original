package com.nsolucoes.contaproapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nsolucoes.contaproapp.data.database.entities.Usuario
import com.nsolucoes.contaproapp.databinding.CardLayoutBinding

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private var listUser = emptyList<Usuario>()

    class UserViewHolder (val binding: CardLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(CardLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = listUser[position]

        holder.binding.textNome.text = user.nomeCompleto.toString()
        holder.binding.textData.text = user.dataNascimento.toString()
        holder.binding.textCPF.text = user.cpf.toString()
        holder.binding.textCEP.text = user.cep.toString()
        holder.binding.textEstado.text = user.estado.toString()
        holder.binding.textCidade.text = user.cidade.toString()
        holder.binding.textBairro.text = user.bairro.toString()
        holder.binding.textComplemento.text = user.complemento.toString()
        holder.binding.textEmail.text = user.email.toString()
        holder.binding.textSenha.text = user.senha.toString()
        holder.binding.textConfirmarSenha.text = user.confirmarSenha.toString()
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    fun setList(list: List<Usuario>){
        listUser = list
        notifyDataSetChanged()
    }
}