package rizkyfadilah.binar.synrgy6.android.challengechapter4.data.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import rizkyfadilah.binar.synrgy6.android.challengechapter4.data.model.CatatanEntity
import rizkyfadilah.binar.synrgy6.android.challengechapter4.data.room.CatatanDao
import rizkyfadilah.binar.synrgy6.android.challengechapter4.data.room.CatatanRepository

class CatatanViewModel(private val repository: CatatanRepository) : ViewModel() {

    // LiveData untuk menyimpan daftar catatan
    val allCatatans = MutableLiveData<List<CatatanEntity>>()
//    val allCatatans: LiveData<List<CatatanEntity>> = repository

    // Fungsi untuk mendapatkan semua catatan
    fun fetchAllCatatans() {
        viewModelScope.launch {
            try {
                allCatatans.value = repository.getAllCatatans()
            } catch (e: Exception) {
                // Handle kesalahan jika diperlukan
            }
        }
    }

    // Fungsi untuk menyisipkan catatan
    fun insertCatatan(catatan: CatatanEntity) {
        viewModelScope.launch {
            repository.insertCatatan(catatan)
        }
    }

    // Fungsi untuk memperbarui catatan
    fun updateCatatan(catatan: CatatanEntity) {
        viewModelScope.launch {
            repository.updateCatatan(catatan)
        }
    }



        // Metode untuk menghapus catatan berdasarkan ID
        fun deleteCatatanById(catatanId: Int) {
            viewModelScope.launch {
                try {
                    // Memanggil fungsi suspend deleteCatatanById di repository
                    repository.deleteCatatanById(catatanId)
                } catch (e: Exception) {
                    // Handle kesalahan jika diperlukan
                }
            }
        }




    // Kelas Factory untuk ViewModel
    class Factory(private val repository: CatatanRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(CatatanViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return CatatanViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}




