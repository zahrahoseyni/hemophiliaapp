package zahra.hosseini.hemophiliaapp.core.datastore.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import zahra.hosseini.hemophiliaapp.authentication.data.model.UserInfoEntity
import zahra.hosseini.hemophiliaapp.main.bleeding.data.model.BleedingEntity
import zahra.hosseini.hemophiliaapp.main.injection.data.model.InjectionEntity
import zahra.hosseini.hemophiliaapp.main.injection.data.model.NotInjectionEntity

@Database(
    entities = [BleedingEntity::class, UserInfoEntity::class, InjectionEntity::class,
        NotInjectionEntity::class],
    version = DatabaseConstants.DATABASE_VERSION
)
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