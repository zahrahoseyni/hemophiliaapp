package zahra.hosseini.hemophiliaapp.core.datastore.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import zahra.hosseini.hemophiliaapp.authentication.data.RegisterRepository
import zahra.hosseini.hemophiliaapp.core.datastore.database.AppDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRegisterRepository(appDao: AppDao): RegisterRepository {
        return RegisterRepository(appDao)
    }

}