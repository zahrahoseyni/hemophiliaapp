package zahra.hosseini.hemophiliaapp.core.datastore.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BleedingEntity::class], version = DatabaseConstants.DATABASE_VERSION)
abstract class HemophiliaDatabase : RoomDatabase() {
    abstract fun doa(): AppDao

    companion object {
        @Volatile
        private var INSTANCE: HemophiliaDatabase? = null

        fun getInstance(context: Context): HemophiliaDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    HemophiliaDatabase::class.java,
                    DatabaseConstants.DATABASE_NAME
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}