package rizkyfadilah.binar.synrgy6.android.challengechapter4.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import rizkyfadilah.binar.synrgy6.android.challengechapter4.model.CatatanEntity
import rizkyfadilah.binar.synrgy6.android.challengechapter4.room.CatatanRepository

class CatatanViewModel(private val repository: CatatanRepository) : ViewModel() {

//    fun getAllCatatans() = repository.getAllCatatans()

    fun insert(catatan: CatatanEntity) = viewModelScope.launch {
        repository.insert(catatan)
    }

    fun update(catatan: CatatanEntity) = viewModelScope.launch {
        repository.update(catatan)
    }

    fun delete(catatan: CatatanEntity) = viewModelScope.launch {
        repository.delete(catatan)
    }
}


