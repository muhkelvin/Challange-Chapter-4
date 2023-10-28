package rizkyfadilah.binar.synrgy6.android.challengechapter4.room;

import androidx.lifecycle.LiveData;

import java.util.List;

import rizkyfadilah.binar.synrgy6.android.challengechapter4.model.Catatan;

// CatatanRepository.kt
// CatatanRepository.kt
class CatatanRepository(private val catatanDao: CatatanDao) {

//    val semuaCatatan: LiveData<List<Catatan>> = catatanDao.getAllCatatan()

    suspend fun tambahCatatan(catatan: Catatan) {
        catatanDao.tambahCatatan(catatan)
    }

    suspend fun updateCatatan(catatan: Catatan) {
        catatanDao.updateCatatan(catatan)
    }

    suspend fun hapusCatatan(catatan: Catatan) {
        catatanDao.hapusCatatan(catatan)
    }

    suspend fun hapusSemuaCatatan() {
        catatanDao.hapusSemuaCatatan()
    }
}

