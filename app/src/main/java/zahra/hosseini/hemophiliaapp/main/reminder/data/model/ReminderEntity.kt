package zahra.hosseini.hemophiliaapp.main.reminder.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import zahra.hosseini.hemophiliaapp.core.datastore.database.DatabaseConstants


@Entity(tableName = DatabaseConstants.REMINDER_TABLE)
data class ReminderEntity(
    @PrimaryKey(autoGenerate = true)
    val reminderId: Int = 0,
    val reminderDescription: String,
    val reminderType: String,
    val reminderTime: String,
)