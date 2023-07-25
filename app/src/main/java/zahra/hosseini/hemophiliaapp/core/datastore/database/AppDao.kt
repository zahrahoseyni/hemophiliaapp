package zahra.hosseini.hemophiliaapp.core.datastore.database

import androidx.room.*
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
}