package zahra.hosseini.hemophiliaapp.authentication.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import zahra.hosseini.hemophiliaapp.core.datastore.database.DatabaseConstants

@Entity(tableName = DatabaseConstants.USER_INFO_TABLE)
data class UserInfoEntity(
    @PrimaryKey(autoGenerate = true)
    val userId: Int = 0,
    @ColumnInfo(name = "phone_number")
    val phoneNumber: String,
    @ColumnInfo(name = "sex")
    val sex: String,
    @ColumnInfo(name = "weight")
    val weight: String,
    @ColumnInfo(name = "height")
    val height: String,
    @ColumnInfo(name = "age")
    val age: String,
    @ColumnInfo(name = "family_history")
    val familyHistory: Boolean,
    @ColumnInfo(name = "time_of_diagnosis")
    val timeOfDiagnosis: String,

    )
