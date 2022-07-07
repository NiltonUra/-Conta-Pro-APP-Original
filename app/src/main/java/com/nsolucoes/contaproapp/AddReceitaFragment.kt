package com.nsolucoes.contaproapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.nsolucoes.contaproapp.adapter.ReceitaAdapter
import com.nsolucoes.contaproapp.data.database.entities.Receita
import com.nsolucoes.contaproapp.databinding.FragmentAddReceitaBinding

class AddReceitaFragment : Fragment() {

    private lateinit var binding: FragmentAddReceitaBinding
    private val viewModel: ReceitaViewModel by viewModels()
    private var adapter = ReceitaAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddReceitaBinding.inflate(layoutInflater, container, false)
        binding.rvReceitas.adapter = adapter
        binding.rvReceitas.setHasFixedSize(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.receitas.observe(viewLifecycleOwner) { adapter.setarLista(it) }

        binding.buttonAdicionarReceita.setOnClickListener {
            viewModel.addReceita(
                Receita(
                    id = 0,
                    tipo = binding.spinnerReceita.selectedItem.toString(),
                    valor = binding.textViewPrecoReceita.text.toString().replace(',', '.').toDouble(),
                    dataHora = binding.editTextDateReceita.text.toString()
                )
            )
        }

    }
}