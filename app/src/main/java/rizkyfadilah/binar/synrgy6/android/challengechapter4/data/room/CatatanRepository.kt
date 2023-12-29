package rizkyfadilah.binar.synrgy6.android.challengechapter4.data.room;

import rizkyfadilah.binar.synrgy6.android.challengechapter4.data.model.CatatanEntity;

// CatatanRepository.kt
// CatatanRepository.kt
import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CatatanRepository(private val catatanDao: CatatanDao) {

    suspend fun getAllCatatans(): List<CatatanEntity> = catatanDao.getAllCatatans()
// fun getAllCatatans(): Flow<List<CatatanEntity>> = catatanDao.getAllCatatans()


    suspend fun insertCatatan(catatan: CatatanEntity) {
        catatanDao.insertCatatan(catatan)
    }

    suspend fun updateCatatan(catatan: CatatanEntity) {
        catatanDao.updateCatatan(catatan)
    }

    suspend fun deleteCatatanById(catatanId: Int) {
        catatanDao.deleteCatatanById(catatanId)
    }

}



