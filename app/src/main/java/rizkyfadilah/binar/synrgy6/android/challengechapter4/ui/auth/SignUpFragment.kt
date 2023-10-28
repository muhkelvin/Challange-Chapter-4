package rizkyfadilah.binar.synrgy6.android.challengechapter4.ui.auth

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import rizkyfadilah.binar.synrgy6.android.challengechapter4.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences = requireActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        binding.btnRegister.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            val confirmPassword = binding.etKonfirmasiPassword.text.toString()

            if (password == confirmPassword) {
                saveCredentials(username, password)

            } else {

                Toast.makeText(requireContext(), "Password mismatch", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun saveCredentials(username: String, password: String) {
        val editor = sharedPreferences.edit()
        editor.putString("username", username)
        editor.putString("password", password)
        editor.apply()
    }

//    private fun navigateToLoginFragment() {
//        requireActivity().supportFragmentManager.beginTransaction()
//            .replace(R.id.fragmentContainer, LoginFragment())
//            .commit()
//    }
}
