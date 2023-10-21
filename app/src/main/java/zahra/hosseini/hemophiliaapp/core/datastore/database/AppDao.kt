package zahra.hosseini.hemophiliaapp.core.datastore.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import zahra.hosseini.hemophiliaapp.authentication.data.model.UserInfoEntity
import zahra.hosseini.hemophiliaapp.main.bleeding.data.model.BleedingEntity
import zahra.hosseini.hemophiliaapp.main.injection.data.model.InjectionEntity
import zahra.hosseini.hemophiliaapp.main.injection.data.model.NotInjectionEntity
import zahra.hosseini.hemophiliaapp.main.reminder.data.model.ReminderEntity

@Dao
interface AppDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUserInfo(userInfoEntity: UserInfoEntity): Long

    @Transaction
    @Query("SELECT * FROM USER_INFO_TABLE")
    fun getUserInfo(): Flow<UserInfoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertInjectionInfo(injectionEntity: InjectionEntity): Long

    @Query("SELECT * FROM INJECTION_TABLE ORDER BY injectionId DESC")
    fun getAllRegisteredInjection(): Flow<List<InjectionEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBleedingInfo(bleedingEntity: BleedingEntity): Long

    @Query("SELECT * FROM BLEEDING_TABLE ORDER BY bleedingId DESC")
    fun getAllRegisteredBleeding(): Flow<List<BleedingEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNotInjectionInfo(notInjectionEntity: NotInjectionEntity): Long

    @Query("SELECT * FROM NOT_INJECTION_TABLE ORDER BY notInjectionId DESC")
    fun getAllRegisteredNotInjection(): Flow<List<NotInjectionEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertReminder(reminderEntity: ReminderEntity): Long

    @Query("SELECT * FROM REMINDER_TABLE ORDER BY reminderId DESC")
    fun getAllReminders(): Flow<List<ReminderEntity>>
}