package rizkyfadilah.binar.synrgy6.android.challengechapter4.room;

import rizkyfadilah.binar.synrgy6.android.challengechapter4.model.CatatanEntity;

// CatatanRepository.kt
// CatatanRepository.kt
import androidx.lifecycle.LiveData

class CatatanRepository(private val catatanDao: CatatanDao) {

    suspend fun getAllCatatans(): List<CatatanEntity> {
        return catatanDao.getAllCatatans()
    }

    suspend fun insert(catatan: CatatanEntity) {
        catatanDao.insert(catatan)
    }

    suspend fun update(catatan: CatatanEntity) {
        catatanDao.update(catatan)
    }

    suspend fun delete(catatan: CatatanEntity) {
        catatanDao.delete(catatan)
    }
}


