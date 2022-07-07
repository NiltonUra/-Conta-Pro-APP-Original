package com.nsolucoes.contaproapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.nsolucoes.contaproapp.data.database.entities.Usuario
import com.nsolucoes.contaproapp.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonContaCriada.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_criarContaFragment2)
        }

        binding.buttonEntrar.setOnClickListener {

            //Pegando o Usuário pelo Email
            viewModel.getUserByEmail(binding.editTextUsuario.text.toString())
                .observe(viewLifecycleOwner) { usuario ->

                    //Validar Usuário e Senha
                    validarSenha(usuario, binding.editTextSenha.text.toString())
                }
        }

    }

    //Função para validar Usuário
    private fun validarSenha(usuario: Usuario?, senhaDigitada: String) {

        //Validar Usuário
        if (usuario == null) {
            Toast.makeText(binding.root.context, "Usuário não encontrado", Toast.LENGTH_SHORT).show()
            Log.i("Login", "Usuário não encontrado")
            return
        }

        //Validar Senha
        if (usuario.senha != senhaDigitada) {
            Toast.makeText(binding.root.context, "Senha Errada", Toast.LENGTH_SHORT).show()
            Log.i("Login", "Senha Errada")
            return
        }

        //Entrar
        findNavController().navigate(R.id.action_loginFragment_to_listDadosFragment)

        //Obs.: Fica avontade para aplicar qualquer validação necessária
    }

    fun validarCampos(cpf: String, senha: String): Boolean {
        //verificar se dados estão vazios
        return !(cpf == "" || senha == "")
    }

    fun entrar() {
        val cpfLogin = binding.editTextUsuario.text.toString()
        val senhaLogin = binding.editTextSenha.text.toString()

        if (validarCampos(cpfLogin, senhaLogin)) {
            //val user = Usuario()
            Toast.makeText(context, "Bem vindo!", Toast.LENGTH_SHORT).show()

            // realizar a navegação entre as páginas após a validação dos dados
            findNavController().navigate(R.id.action_loginFragment_to_listDadosFragment)
        }
    }
}