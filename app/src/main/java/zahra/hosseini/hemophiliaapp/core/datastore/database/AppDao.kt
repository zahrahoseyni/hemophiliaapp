package zahra.hosseini.hemophiliaapp.core.datastore.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import zahra.hosseini.hemophiliaapp.authentication.data.UserInfoEntity
import zahra.hosseini.hemophiliaapp.main.data.BleedingEntity
import zahra.hosseini.hemophiliaapp.main.data.InjectionEntity

@Dao
interface AppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBleeding(bleedingEntity: BleedingEntity)

    @Query("SELECT * FROM BLEEDING_TABLE ORDER BY bleedingId DESC")
    fun getAllRegisteredBleeding(): MutableList<BleedingEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUserInfo(userInfoEntity: UserInfoEntity): Long

    @Transaction
    @Query("SELECT * FROM USER_INFO_TABLE")
    fun getUserInfo(): Flow<UserInfoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertInjectionInfo(injectionEntity: InjectionEntity): Long

    @Query("SELECT * FROM INJECTION_TABLE ORDER BY injectionId DESC")
    fun getAllRegisteredInjection(): Flow<List<InjectionEntity>>
}