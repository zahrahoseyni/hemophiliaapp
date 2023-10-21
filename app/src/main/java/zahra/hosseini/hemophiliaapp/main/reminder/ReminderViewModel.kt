package zahra.hosseini.hemophiliaapp.main.reminder

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import zahra.hosseini.hemophiliaapp.main.reminder.data.ReminderRepository
import zahra.hosseini.hemophiliaapp.main.reminder.data.model.ReminderEntity
import javax.inject.Inject

@HiltViewModel
class ReminderViewModel @Inject constructor(
    private val reminderRepository: ReminderRepository,
    @ApplicationContext context: Context,
) : ViewModel() {

    private val _response = MutableLiveData<Long>()
    val response: LiveData<Long> = _response

    fun insertReminder(reminderEntity: ReminderEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            _response.postValue(reminderRepository.insertReminder(reminderEntity))
        }
    }

    private val _reminderList = MutableStateFlow<List<ReminderEntity>>(emptyList())
    val reminderList: StateFlow<List<ReminderEntity>> = _reminderList

    fun getAllReminders() {
        viewModelScope.launch(Dispatchers.IO) {
            reminderRepository.getAllReminders()
                .catch { e ->
                    //Log error here
                    e.message.toString()
                }
                .collect {
                    _reminderList.value = it
                }
        }
    }
}