package rizkyfadilah.binar.synrgy6.android.challengechapter4.ui.auth

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import rizkyfadilah.binar.synrgy6.android.challengechapter4.MainActivity
import rizkyfadilah.binar.synrgy6.android.challengechapter4.databinding.FragmentSignBinding

class SignFragment : Fragment() {

    private lateinit var binding: FragmentSignBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvBelum.setOnClickListener {
            SignFragmentDirections.actionSignFragmentToSignUpFragment().also {
                findNavController().navigate(it)
            }
        }

        sharedPreferences = requireActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        binding.btnLogin.setOnClickListener {
            val username = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            if (checkLogin(username, password)) {
                startActivity(Intent(requireContext(), MainActivity::class.java))
                requireActivity().finish()
            } else {
                // Handle login failure
                // For simplicity, showing a toast message
                // You may want to implement a proper UI feedback
                Toast.makeText(requireContext(), "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun checkLogin(username: String, password: String): Boolean {
        val storedUsername = sharedPreferences.getString("username", "") ?: ""
        val storedPassword = sharedPreferences.getString("password", "") ?: ""

        return username == storedUsername && password == storedPassword
    }
}
