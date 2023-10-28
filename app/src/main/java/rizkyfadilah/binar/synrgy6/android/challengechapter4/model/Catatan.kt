package rizkyfadilah.binar.synrgy6.android.challengechapter4.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "catatan_table")
data class Catatan(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo("isiCatatan") var type: String,
)
