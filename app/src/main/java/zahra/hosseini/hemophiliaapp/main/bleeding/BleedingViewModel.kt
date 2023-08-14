package zahra.hosseini.hemophiliaapp.main.bleeding

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
import zahra.hosseini.hemophiliaapp.main.bleeding.data.model.BleedingEntity
import zahra.hosseini.hemophiliaapp.main.bleeding.data.BleedingRepository
import javax.inject.Inject

@HiltViewModel
class BleedingViewModel @Inject constructor(
    private val bleedingRepository: BleedingRepository,
    @ApplicationContext context: Context,
) : ViewModel() {


    private val _response = MutableLiveData<Long>()
    val response: LiveData<Long> = _response

    fun insertBleedingDetails(bleedingEntity: BleedingEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            _response.postValue(bleedingRepository.insertBleedingDetails(bleedingEntity))
        }
    }


    private val _bleedingList = MutableStateFlow<List<BleedingEntity>>(emptyList())
    val bleedingList: StateFlow<List<BleedingEntity>> = _bleedingList

    fun getAllBleedingList() {
        viewModelScope.launch(Dispatchers.IO) {
            bleedingRepository.getAllRegisteredBleeding()
                .catch { e ->
                    //Log error here
                    e.message.toString()
                }
                .collect {
                    _bleedingList.value = it
                }
        }
    }


}