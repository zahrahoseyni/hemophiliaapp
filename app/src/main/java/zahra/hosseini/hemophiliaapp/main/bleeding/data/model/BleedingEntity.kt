package zahra.hosseini.hemophiliaapp.main.bleeding.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import zahra.hosseini.hemophiliaapp.core.datastore.database.DatabaseConstants

@Entity(tableName = DatabaseConstants.BLEEDING_TABLE)
data class BleedingEntity(
    @PrimaryKey(autoGenerate = true)
    val bleedingId: Int = 0,
    @ColumnInfo(name = "reason")
    val bleedingReason: String,
    @ColumnInfo(name = "topic")
    val bleedingTopic: String,
    @ColumnInfo(name = "intensity")
    val bleedingIntensity: String,
    @ColumnInfo(name = "bleeding_date")
    val bleedingDate: String,
    @ColumnInfo(name = "bleeding_time")
    val bleedingTime: String,
    @ColumnInfo(name = "amount_of_disability")
    val amountOfDisability: String,
    @ColumnInfo(name = "amount_of_pain")
    val amountOfPain: String,
    @ColumnInfo(name = "using_sedative")
    val usingSedative: String,
    @ColumnInfo(name = "sedative_name")
    val sedativeName: String?

)
