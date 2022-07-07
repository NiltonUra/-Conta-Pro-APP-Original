package com.nsolucoes.contaproapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.nsolucoes.contaproapp.adapter.UserAdapter
import com.nsolucoes.contaproapp.databinding.FragmentEditarPerfilBinding
import com.nsolucoes.contaproapp.databinding.FragmentListDadosBinding


class EditarPerfilFragment : Fragment() {

    private lateinit var binding: FragmentEditarPerfilBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEditarPerfilBinding.inflate(layoutInflater, container, false)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val adapter = UserAdapter()
        binding.rvPerfil.layoutManager = LinearLayoutManager(context)
        binding.rvPerfil.adapter = adapter
        binding.rvPerfil.setHasFixedSize(true)

        mainViewModel.selectUsers.observe(viewLifecycleOwner){
                response -> adapter.setList(response)
        }

        return binding.root
    }
}