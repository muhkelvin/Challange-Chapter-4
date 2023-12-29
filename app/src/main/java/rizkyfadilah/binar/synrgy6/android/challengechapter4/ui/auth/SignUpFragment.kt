package rizkyfadilah.binar.synrgy6.android.challengechapter4.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.datastore.auth.AuthManajer
import com.example.datastore.auth.AuthRepository
import com.example.datastore.auth.AuthViewModel
import com.example.datastore.auth.datastore
import rizkyfadilah.binar.synrgy6.android.challengechapter4.R
import rizkyfadilah.binar.synrgy6.android.challengechapter4.databinding.FragmentSignBinding
import rizkyfadilah.binar.synrgy6.android.challengechapter4.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {
    private lateinit var binding: FragmentSignUpBinding

    private val authManager: AuthManajer by lazy {
        AuthManajer.getInstance(requireContext().datastore)
    }

    private val repository: AuthRepository by lazy {
        AuthRepository(authManager)
    }

    private val viewModel: AuthViewModel by viewModels {
        AuthViewModel.Factory(repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btDaftar.setOnClickListener {
            val valueUsername = binding.etUsername.text.toString()
            val valueEmail = binding.etEmail.text.toString()
            val valuePassword = binding.etPassword.text.toString()
            val valueKonfirmasi = binding.etKonfirmasi.text.toString()

            if (valueEmail.isNotEmpty() && valueUsername.isNotEmpty() && valuePassword.isNotEmpty() && valueKonfirmasi.isNotEmpty()) {
                if (valuePassword == valueKonfirmasi) {
                    viewModel.setUserCredentials(valueUsername, valueEmail, valuePassword)
                    navigateToLoginFragment()
                } else {
                    Toast.makeText(requireContext(), "Password dan konfirmasi password harus sama", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "Email, Username, Password, dan Konfirmasi harus diisi", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun navigateToLoginFragment() {
        findNavController().navigate(R.id.action_signUpFragment_to_signFragment)
    }
}

