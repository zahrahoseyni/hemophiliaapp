package zahra.hosseini.hemophiliaapp.main.injection.data

import kotlinx.coroutines.flow.Flow
import zahra.hosseini.hemophiliaapp.core.datastore.database.AppDao
import zahra.hosseini.hemophiliaapp.main.injection.data.model.InjectionEntity
import zahra.hosseini.hemophiliaapp.main.injection.data.model.NotInjectionEntity

class InjectionRepository(private val appDao: AppDao) {

    //Injection
    suspend fun insertInjectionDetails(injectionEntity: InjectionEntity): Long {
        return appDao.insertInjectionInfo(injectionEntity)
    }

    fun getAllRegisteredInjection(): Flow<List<InjectionEntity>> {
        return appDao.getAllRegisteredInjection()
    }

    //Not Injection
    suspend fun insertNotInjectionDetails(notInjectionEntity: NotInjectionEntity): Long {
        return appDao.insertNotInjectionInfo(notInjectionEntity)
    }

    fun getAllRegisteredNotInjection(): Flow<List<NotInjectionEntity>> {
        return appDao.getAllRegisteredNotInjection()
    }

}