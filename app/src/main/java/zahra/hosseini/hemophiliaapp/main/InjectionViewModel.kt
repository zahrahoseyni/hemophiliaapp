package zahra.hosseini.hemophiliaapp.main

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
import zahra.hosseini.hemophiliaapp.authentication.data.EmptyUserInfoEntity
import zahra.hosseini.hemophiliaapp.authentication.data.RegisterRepository
import zahra.hosseini.hemophiliaapp.authentication.data.UserInfoEntity
import zahra.hosseini.hemophiliaapp.core.datastore.DataStoreManager
import zahra.hosseini.hemophiliaapp.main.data.InjectionEntity
import zahra.hosseini.hemophiliaapp.main.data.InjectionRepository
import javax.inject.Inject

@HiltViewModel
class InjectionViewModel @Inject constructor(
    private val injectionRepository: InjectionRepository,
    @ApplicationContext context: Context,
) : ViewModel() {


    private val _response = MutableLiveData<Long>()
    val response: LiveData<Long> = _response

    fun insertInjectionDetails(injectionEntity: InjectionEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            _response.postValue(injectionRepository.insertInjectionDetails(injectionEntity))
        }
    }

    /**
     * Retrieve user details
     */

    private val _injectionList = MutableStateFlow<List<InjectionEntity>>(emptyList())
    val injectionList: StateFlow<List<InjectionEntity>> = _injectionList

    fun getAllInjectionList() {
        viewModelScope.launch(Dispatchers.IO) {
            injectionRepository.getAllRegisteredInjection()
                .catch { e ->
                    //Log error here
                    e.message.toString()
                }
                .collect {
                    _injectionList.value = it
                }
        }
    }


}