package zahra.hosseini.hemophiliaapp.main.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import zahra.hosseini.hemophiliaapp.core.datastore.database.DatabaseConstants

@Entity(tableName = DatabaseConstants.INJECTION_TABLE)
data class InjectionEntity(
    @PrimaryKey(autoGenerate = true)
    val injectionId: Int = 0,
    @ColumnInfo(name = "active_inhibitor")
    val activeInhibitor: String,
    @ColumnInfo(name = "treatment_type")
    val treatmentType: String,
    @ColumnInfo(name = "dosage")
    val dosage: String,
    @ColumnInfo(name = "injection_date")
    val injectionDate: String,
    @ColumnInfo(name = "injection_time")
    val injectionTime: String,
    @ColumnInfo(name = "injection_reason")
    val injectionReason: String
)
