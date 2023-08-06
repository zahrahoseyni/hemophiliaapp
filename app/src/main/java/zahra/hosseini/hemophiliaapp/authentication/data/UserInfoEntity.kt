package zahra.hosseini.hemophiliaapp.authentication.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import zahra.hosseini.hemophiliaapp.core.datastore.database.DatabaseConstants

@Entity(tableName = DatabaseConstants.USER_INFO_TABLE)
open class UserInfoEntity(
    @PrimaryKey(autoGenerate = false)
    var phoneNumber: String,
    @ColumnInfo(name = "sex")
    var sex: String,
    @ColumnInfo(name = "weight")
    var weight: String,
    @ColumnInfo(name = "height")
    var height: String,
    @ColumnInfo(name = "age")
    var age: String,
    @ColumnInfo(name = "family_history")
    var familyHistory: Boolean,
    @ColumnInfo(name = "time_of_diagnosis")
    var timeOfDiagnosis: String,

    )
