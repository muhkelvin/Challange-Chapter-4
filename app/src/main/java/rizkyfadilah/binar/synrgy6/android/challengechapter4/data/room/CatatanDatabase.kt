package rizkyfadilah.binar.synrgy6.android.challengechapter4.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import rizkyfadilah.binar.synrgy6.android.challengechapter4.data.model.CatatanEntity

// CatatanDatabase.kt
@Database(entities = [CatatanEntity::class], version = 1, exportSchema = false)
abstract class CatatanDatabase : RoomDatabase() {

    abstract fun catatanDao(): CatatanDao

    companion object {
        @Volatile
        private var INSTANCE: CatatanDatabase? = null

        fun getDatabase(context: Context): CatatanDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CatatanDatabase::class.java,
                    "catatan_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}

