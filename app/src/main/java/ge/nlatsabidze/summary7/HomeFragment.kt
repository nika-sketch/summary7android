package ge.nlatsabidze.summary7

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import ge.nlatsabidze.summary7.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override fun start() {
        val email = binding.textView
        email.text = arguments?.getString("userEmail")

        binding.button5.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_loginFragment)
        }
    }
}