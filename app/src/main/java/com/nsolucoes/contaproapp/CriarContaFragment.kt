package com.nsolucoes.contaproapp

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.nsolucoes.contaproapp.data.database.entities.Usuario
import com.nsolucoes.contaproapp.databinding.FragmentCadastroUsuarioBinding

class CriarContaFragment : Fragment() {

    private lateinit var binding: FragmentCadastroUsuarioBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCadastroUsuarioBinding.inflate(layoutInflater, container, false)

        if (ActivityCompat.checkSelfPermission(binding.root.context, Manifest.permission.CAMERA) !=
            PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this.requireActivity(), arrayOf(Manifest.permission.CAMERA), 111
            )
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonConcluir.setOnClickListener {
            inserirBanco()
        }

        binding.textViewSelfie.setOnClickListener {
            var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }
    }

    fun verificarCampos(
        nomeCompleto: String,
        dataNascimento: String,
        cpf: String,
        cep: String,
        estado: String,
        cidade: String,
        bairro: String,
        complemento: String,
        email: String,
        senha: String,
        confirmarSenha: String
    ): Boolean {

        //verificar se dados estão vazios
        return !(nomeCompleto == "" || dataNascimento == "" || cpf == "" ||
                cep == "" || estado == "" || cidade == "" ||
                bairro == "" || complemento == "" || email == "" ||
                senha == "" || confirmarSenha == "")
    }

    fun inserirBanco() {
        val nomeCompleto = binding.editTextNomeCompleto.text.toString()
        val dataNascimento = binding.editTextNascimento.text.toString()
        val cpf = binding.editTextCPF.text.toString()
        val cep = binding.editTextNumberCep.text.toString()
        val estado = binding.editTextEstado.text.toString()
        val cidade = binding.editTextCidade.text.toString()
        //val logradouro = binding.editTextLogradouro.text.toString()
        //val numero = binding.editTextNumber.text.toString()
        val bairro = binding.editTextBairro.text.toString()
        val complemento = binding.editTextComplemento.text.toString()
        val email = binding.editTextEmail.text.toString()
        val senha = binding.editTextSenhaCad.text.toString()
        val confirmarSenha = binding.editTextConfirmaSenha.text.toString()

        if (verificarCampos(
                nomeCompleto,
                dataNascimento,
                cpf,
                cep,
                estado,
                cidade,
                bairro,
                complemento,
                email,
                senha,
                confirmarSenha
            )
        ) {

            val user = Usuario(
                0, nomeCompleto, dataNascimento, cpf, cep, estado, cidade,
                bairro, complemento, email, senha, confirmarSenha
            )
            mainViewModel.addUser(user)
            Toast.makeText(context, "Usuário cadastrado", Toast.LENGTH_SHORT).show()

            // realizar a navegação entre as páginas após a validação dos dados
            findNavController().navigate(R.id.action_criarContaFragment2_to_loginFragment)
        } else {
            Toast.makeText(context, "Dados incompletos", Toast.LENGTH_SHORT).show()
        }
    }
}