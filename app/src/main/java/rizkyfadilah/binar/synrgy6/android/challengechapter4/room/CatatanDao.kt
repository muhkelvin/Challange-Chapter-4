package rizkyfadilah.binar.synrgy6.android.challengechapter4.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import rizkyfadilah.binar.synrgy6.android.challengechapter4.model.CatatanEntity

// CatatanDao.kt
import androidx.room.*

@Dao
interface CatatanDao {
    @Query("SELECT * FROM catatans")
    suspend fun getAllCatatans(): List<CatatanEntity>

    @Insert
    suspend fun insert(catatan: CatatanEntity)

    @Update
    suspend fun update(catatan: CatatanEntity)

    @Delete
    suspend fun delete(catatan: CatatanEntity)
}

