package zahra.hosseini.hemophiliaapp.core.datastore.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import zahra.hosseini.hemophiliaapp.authentication.data.UserInfoEntity
import zahra.hosseini.hemophiliaapp.main.data.BleedingEntity

@Dao
interface AppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBleeding(bleedingEntity: BleedingEntity)

    @Update

    fun updateBleeding(bleedingEntity: BleedingEntity)

    @Delete
    fun deleteBleeding(bleedingEntity: BleedingEntity)

    @Query("SELECT * FROM BLEEDING_TABLE ORDER BY bleedingId DESC")
    fun getAllRegisteredBleeding(): MutableList<BleedingEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUserInfo(userInfoEntity: UserInfoEntity): Long

    @Transaction
    @Query("SELECT * FROM USER_INFO_TABLE")
    fun getUserInfo(): Flow<UserInfoEntity>

}