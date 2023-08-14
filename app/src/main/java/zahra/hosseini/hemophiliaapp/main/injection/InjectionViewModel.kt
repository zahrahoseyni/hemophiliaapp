package zahra.hosseini.hemophiliaapp.main.injection

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
import zahra.hosseini.hemophiliaapp.main.injection.data.model.InjectionEntity
import zahra.hosseini.hemophiliaapp.main.injection.data.InjectionRepository
import zahra.hosseini.hemophiliaapp.main.injection.data.model.NotInjectionEntity
import javax.inject.Inject

@HiltViewModel
class InjectionViewModel @Inject constructor(
    private val injectionRepository: InjectionRepository,
    @ApplicationContext context: Context,
) : ViewModel() {

    //Injection
    private val _injectionResponse = MutableLiveData<Long>()
    val injectionResponse: LiveData<Long> = _injectionResponse

    private val _injectionList = MutableStateFlow<List<InjectionEntity>>(emptyList())
    val injectionList: StateFlow<List<InjectionEntity>> = _injectionList

    fun insertInjectionDetails(injectionEntity: InjectionEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            _injectionResponse.postValue(injectionRepository.insertInjectionDetails(injectionEntity))
        }
    }

    fun getAllInjectionList() {
        viewModelScope.launch(Dispatchers.IO) {
            injectionRepository.getAllRegisteredInjection().catch { e ->
                //Log error here
                e.message.toString()
            }.collect {
                _injectionList.value = it
            }
        }
    }

    //Not Injection
    private val _notInjectionResponse = MutableLiveData<Long>()
    val notInjectionResponse: LiveData<Long> = _notInjectionResponse

    private val _notInjectionList = MutableStateFlow<List<NotInjectionEntity>>(emptyList())
    val notInjectionList: StateFlow<List<NotInjectionEntity>> = _notInjectionList

    fun insertNotInjectionDetails(notInjectionEntity: NotInjectionEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            _injectionResponse.postValue(
                injectionRepository.insertNotInjectionDetails(
                    notInjectionEntity
                )
            )
        }
    }

    fun getAllNotInjectionList() {
        viewModelScope.launch(Dispatchers.IO) {
            injectionRepository.getAllRegisteredNotInjection().catch { e ->
                //Log error here
                e.message.toString()
            }.collect {
                _notInjectionList.value = it
            }
        }
    }


}