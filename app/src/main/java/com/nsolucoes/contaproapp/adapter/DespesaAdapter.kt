package com.nsolucoes.contaproapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nsolucoes.contaproapp.R
import com.nsolucoes.contaproapp.data.database.entities.Despesa

class DespesaAdapter : RecyclerView.Adapter<DespesaAdapter.DespesaViewHolder>() {

    private var despesas = emptyList<Despesa>()
    fun setarLista(despesas: List<Despesa>) {
        this.despesas = despesas
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DespesaViewHolder {
        return DespesaViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.despesa_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: DespesaViewHolder, position: Int) {
        holder.dataDespesa.text = despesas[position].dataHora
        holder.valorDespesa.text = despesas[position].valor.toString()
        holder.tipoDespesa.text = despesas[position].tipo
    }

    override fun getItemCount(): Int = despesas.size

    inner class DespesaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dataDespesa = view.findViewById<TextView>(R.id.textViewDataDespesa)
        val valorDespesa = view.findViewById<TextView>(R.id.textViewValorDespesa)
        val tipoDespesa = view.findViewById<TextView>(R.id.textViewTipoDespesa)
    }
}