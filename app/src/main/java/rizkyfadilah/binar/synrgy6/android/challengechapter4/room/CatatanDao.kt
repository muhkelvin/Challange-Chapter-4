package rizkyfadilah.binar.synrgy6.android.challengechapter4.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import rizkyfadilah.binar.synrgy6.android.challengechapter4.model.Catatan

// CatatanDao.kt
@Dao
interface CatatanDao {

    @Query("SELECT * FROM catatan_table")
    fun getAllCatatan(): LiveData<List<Catatan>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun tambahCatatan(catatan: Catatan)

    @Update
    suspend fun updateCatatan(catatan: Catatan)

    @Delete
    suspend fun hapusCatatan(catatan: Catatan)

    @Query("DELETE FROM catatan_table")
    suspend fun hapusSemuaCatatan()
}
