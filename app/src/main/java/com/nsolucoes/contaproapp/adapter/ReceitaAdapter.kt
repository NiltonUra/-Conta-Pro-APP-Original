package com.nsolucoes.contaproapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nsolucoes.contaproapp.R
import com.nsolucoes.contaproapp.data.database.entities.Despesa
import com.nsolucoes.contaproapp.data.database.entities.Receita

class ReceitaAdapter : RecyclerView.Adapter<ReceitaAdapter.DespesaViewHolder>() {

    private var receitas = emptyList<Receita>()
    fun setarLista(receitas: List<Receita>) {
        this.receitas = receitas
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DespesaViewHolder {
        return DespesaViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.receita_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: DespesaViewHolder, position: Int) {
        holder.dataReceita.text = receitas[position].dataHora
        holder.valorReceita.text = receitas[position].valor.toString()
        holder.tipoReceita.text = receitas[position].tipo
    }

    override fun getItemCount(): Int = receitas.size

    inner class DespesaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dataReceita = view.findViewById<TextView>(R.id.textViewDataReceita)
        val valorReceita = view.findViewById<TextView>(R.id.textViewValorReceita)
        val tipoReceita = view.findViewById<TextView>(R.id.textViewTipoReceita)
    }
}