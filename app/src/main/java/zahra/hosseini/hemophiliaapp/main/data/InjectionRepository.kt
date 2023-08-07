package zahra.hosseini.hemophiliaapp.main.data

import kotlinx.coroutines.flow.Flow
import zahra.hosseini.hemophiliaapp.core.datastore.database.AppDao

class InjectionRepository(private val appDao: AppDao) {

    suspend fun insertInjectionDetails(injectionEntity: InjectionEntity): Long {
        return appDao.insertInjectionInfo(injectionEntity)
    }

    fun getAllRegisteredInjection(): Flow<List<InjectionEntity>> {
        return appDao.getAllRegisteredInjection()
    }

}