package zahra.hosseini.hemophiliaapp.main.injection.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import zahra.hosseini.hemophiliaapp.core.datastore.database.DatabaseConstants

@Entity(tableName = DatabaseConstants.NOT_INJECTION_TABLE)
data class NotInjectionEntity(
    @PrimaryKey(autoGenerate = true)
    val notInjectionId: Int = 0,
    @ColumnInfo(name = "not_injection_date")
    val injectionDate: String,
    @ColumnInfo(name = "not_injection_reason")
    val injectionReason: String
)
