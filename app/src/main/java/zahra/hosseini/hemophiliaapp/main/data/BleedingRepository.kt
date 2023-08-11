package zahra.hosseini.hemophiliaapp.main.data

import kotlinx.coroutines.flow.Flow
import zahra.hosseini.hemophiliaapp.core.datastore.database.AppDao

class BleedingRepository(private val appDao: AppDao) {

    suspend fun insertBleedingDetails(bleedingEntity: BleedingEntity): Long {
        return appDao.insertBleedingInfo(bleedingEntity)
    }

    fun getAllRegisteredBleeding(): Flow<List<BleedingEntity>> {
        return appDao.getAllRegisteredBleeding()
    }

}