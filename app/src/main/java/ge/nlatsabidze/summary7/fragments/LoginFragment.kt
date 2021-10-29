package ge.nlatsabidze.summary7.fragments

import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import ge.nlatsabidze.summary7.BaseFragment
import ge.nlatsabidze.summary7.R
import ge.nlatsabidze.summary7.databinding.FragmentLoginBinding
import ge.nlatsabidze.summary7.viewModel.HomeViewModel

class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {


    companion object {
        const val EMAIL = "eve.holt@reqres.in"
    }

    private val viewModel: HomeViewModel by viewModels()


    override fun start() {
        loginButtonClicked()
        registerButtonClicked()
    }

    private fun loginButtonClicked() {

        binding.btnLogin.setOnClickListener {

            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            viewModel.login(email, password)
            viewModel.loginResponseData.observe(viewLifecycleOwner, { response ->
                if (response.isSuccessful && (email == EMAIL)) {

                    setFragmentResultListener("information") { requestKey, bundle ->
                        val registerEmail = bundle.getString("email").toString()
                        val registerPassword = bundle.getString("password")
                        binding.etEmail.setText(registerEmail)
                        binding.etPassword.setText(registerPassword)

                        if (email == registerEmail && password == registerPassword) {
                            val emailBundle = bundleOf("userEmail" to email)
                            findNavController().navigate(R.id.action_loginFragment_to_homeFragment, emailBundle)
                        }
                    }
                }
            })
        }
    }

    private fun registerButtonClicked() {
        binding.btnRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }
}
