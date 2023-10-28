package rizkyfadilah.binar.synrgy6.android.challengechapter4.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import rizkyfadilah.binar.synrgy6.android.challengechapter4.model.Catatan
import rizkyfadilah.binar.synrgy6.android.challengechapter4.room.CatatanRepository

// CatatanViewModel.kt
class CatatanViewModel(private val repository: CatatanRepository) : ViewModel() {

//    val semuaCatatan: LiveData<List<Catatan>> = repository.semuaCatatan

    fun tambahCatatan(catatan: Catatan) = viewModelScope.launch {
        repository.tambahCatatan(catatan)
    }

    fun updateCatatan(catatan: Catatan) = viewModelScope.launch {
        repository.updateCatatan(catatan)
    }

    fun hapusCatatan(catatan: Catatan) = viewModelScope.launch {
        repository.hapusCatatan(catatan)
    }

    fun hapusSemuaCatatan() = viewModelScope.launch {
        repository.hapusSemuaCatatan()
    }
}

