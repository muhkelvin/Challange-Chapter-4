package rizkyfadilah.binar.synrgy6.android.challengechapter4.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import rizkyfadilah.binar.synrgy6.android.challengechapter4.data.model.CatatanEntity

// CatatanDao.kt
import androidx.room.*

@Dao
interface CatatanDao {
    @Query("SELECT * FROM catatans")
    suspend fun getAllCatatans(): List<CatatanEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCatatan(catatanEntity: CatatanEntity)

    @Update
    suspend fun updateCatatan(catatanEntity: CatatanEntity)

    @Query("DELETE FROM catatans WHERE id = :catatanId")
    suspend fun deleteCatatanById(catatanId: Int)

}


