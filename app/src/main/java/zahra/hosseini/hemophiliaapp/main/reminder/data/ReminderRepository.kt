package zahra.hosseini.hemophiliaapp.main.reminder.data

import kotlinx.coroutines.flow.Flow
import zahra.hosseini.hemophiliaapp.core.datastore.database.AppDao
import zahra.hosseini.hemophiliaapp.main.bleeding.data.model.BleedingEntity
import zahra.hosseini.hemophiliaapp.main.reminder.data.model.ReminderEntity

class ReminderRepository(private val appDao: AppDao) {

    suspend fun insertReminder(reminderEntity: ReminderEntity): Long {
        return appDao.insertReminder(reminderEntity)
    }

    fun getAllReminders(): Flow<List<ReminderEntity>> {
        return appDao.getAllReminders()
    }

}