package rizkyfadilah.binar.synrgy6.android.challengechapter4

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.datastore.auth.AuthManajer
import com.example.datastore.auth.AuthRepository
import com.example.datastore.auth.AuthViewModel
import com.example.datastore.auth.datastore
import kotlinx.coroutines.launch
import rizkyfadilah.binar.synrgy6.android.challengechapter4.databinding.FragmentSpashBinding


class SpashFragment : Fragment() {
    private lateinit var binding: FragmentSpashBinding

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
        binding = FragmentSpashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler().postDelayed({
            checkLoginStatus()
        }, SPLASH_DELAY)
    }

    private fun checkLoginStatus() {
//        lifecycleScope.launch {
//            if (authManager.loginStatus()) {
//                // Pengguna sudah login, arahkan ke layar home
//                findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
//            } else {
//                // Pengguna belum login, arahkan ke layar login
//                findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
//            }
//        }


        lifecycleScope.launch {
            if (authManager.loginStatus()) {
                // Pengguna sudah login, arahkan ke layar home
                findNavController().navigate(R.id.action_spashFragment_to_homeFragment)
            } else {
                // Pengguna belum login, arahkan ke layar login
                findNavController().navigate(R.id.action_spashFragment_to_signFragment)
            }
        }
    }


    companion object {
        private const val SPLASH_DELAY = 3000L
    }
}