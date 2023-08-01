package zahra.hosseini.hemophiliaapp.core.datastore.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import zahra.hosseini.hemophiliaapp.core.datastore.database.AppDao
import zahra.hosseini.hemophiliaapp.core.datastore.database.HemophiliaDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
private object DatabaseModule {

    @Provides
    fun provideAppDao(appDatabase: HemophiliaDatabase): AppDao {
        return appDatabase.doa()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): HemophiliaDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            HemophiliaDatabase::class.java,
            "appDB"
        ).build()
    }

}