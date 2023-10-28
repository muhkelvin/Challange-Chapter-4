package rizkyfadilah.binar.synrgy6.android.challengechapter4.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import rizkyfadilah.binar.synrgy6.android.challengechapter4.room.CatatanDatabase
import rizkyfadilah.binar.synrgy6.android.challengechapter4.room.CatatanRepository

class CatatanViewModelFactory(private val application: Application) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CatatanViewModel::class.java)) {
            val repository = CatatanRepository(
                CatatanDatabase.getDatabase(application).catatanDao()
            )
            return CatatanViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
