package rizkyfadilah.binar.synrgy6.android.challengechapter4.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import rizkyfadilah.binar.synrgy6.android.challengechapter4.R
import rizkyfadilah.binar.synrgy6.android.challengechapter4.data.room.CatatanDatabase
import rizkyfadilah.binar.synrgy6.android.challengechapter4.data.room.CatatanRepository
import rizkyfadilah.binar.synrgy6.android.challengechapter4.data.viewmodel.CatatanViewModel
import rizkyfadilah.binar.synrgy6.android.challengechapter4.databinding.FragmentHomeBinding
import rizkyfadilah.binar.synrgy6.android.challengechapter4.ui.adapter.CatatanAdapter

class HomeFragment : Fragment() {

    // Deklarasikan variabel binding
    private lateinit var binding: FragmentHomeBinding

    private lateinit var adapter: CatatanAdapter
//    private val database by lazy { CatatanRepository(catatanDao = Ca) }
    private val viewModel : CatatanViewModel by lazy {
        ViewModelProvider(this).get(CatatanViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate layout menggunakan View Binding
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Penggunaan binding di sini


        // Anda dapat mengakses elemen UI lainnya seperti biasa melalui binding
        // binding.buttonSubmit.setOnClickListener { /* Handle klik tombol */ }
    }


}
