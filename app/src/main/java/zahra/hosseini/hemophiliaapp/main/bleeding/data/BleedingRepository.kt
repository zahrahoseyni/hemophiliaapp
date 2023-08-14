package zahra.hosseini.hemophiliaapp.main.bleeding.data

import kotlinx.coroutines.flow.Flow
import zahra.hosseini.hemophiliaapp.core.datastore.database.AppDao
import zahra.hosseini.hemophiliaapp.main.bleeding.data.model.BleedingEntity

class BleedingRepository(private val appDao: AppDao) {

    suspend fun insertBleedingDetails(bleedingEntity: BleedingEntity): Long {
        return appDao.insertBleedingInfo(bleedingEntity)
    }

    fun getAllRegisteredBleeding(): Flow<List<BleedingEntity>> {
        return appDao.getAllRegisteredBleeding()
    }

}