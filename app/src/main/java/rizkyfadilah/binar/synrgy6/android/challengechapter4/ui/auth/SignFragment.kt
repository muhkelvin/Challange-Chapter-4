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


class SignFragment : Fragment() {
    private lateinit var binding: FragmentSignBinding

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
        binding = FragmentSignBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btLogin.setOnClickListener {
            val valueEmail = binding.etEmail.text.toString()
            val valuePassword = binding.etPassword.text.toString()

            if (valueEmail.isNotEmpty() && valuePassword.isNotEmpty()) {
                viewModel.login(valueEmail, valuePassword).observe(viewLifecycleOwner) { isSuccess ->
                    if (isSuccess) {
                        navigateToHomeFragment()
                    } else {
                        Toast.makeText(requireContext(), "Login Gagal. Cek Email dan Password", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(requireContext(), "Email dan Password harus diisi", Toast.LENGTH_SHORT).show()
            }
        }

        binding.tvRegister.setOnClickListener {
            navigateToRegisterFragment()
        }
    }

    private fun navigateToHomeFragment() {
        findNavController().navigate(R.id.action_signFragment_to_homeFragment)
    }

    private fun navigateToRegisterFragment() {
        findNavController().navigate(R.id.action_signFragment_to_signUpFragment)
    }
}
