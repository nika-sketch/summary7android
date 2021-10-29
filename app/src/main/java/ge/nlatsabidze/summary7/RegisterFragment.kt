package ge.nlatsabidze.summary7

import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.LENGTH_SHORT
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import ge.nlatsabidze.summary7.BaseFragment
import ge.nlatsabidze.summary7.databinding.FragmentRegisterBinding
import ge.nlatsabidze.summary7.viewModel.HomeViewModel

class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {

    private val viewModel: HomeViewModel by viewModels()

    companion object {
        const val EMAIL = "eve.holt@reqres.in"
    }

    override fun start() {
        fillInformation()
    }

    private fun fillInformation() {

        binding.btnRegstr.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            val repeatedPassword = binding.etRepeatPassword.text.toString()

            viewModel.register(email, password)
            if (password == repeatedPassword && email == EMAIL) {
                setFragmentResult("information", bundleOf("email" to email, "password" to password))
                findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
            } else {
                Toast.makeText(requireContext(), "Invalid password repetition", Toast.LENGTH_SHORT).show()
            }
        }
    }
}