package zahra.hosseini.hemophiliaapp.authentication

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
import zahra.hosseini.hemophiliaapp.authentication.data.model.EmptyUserInfoEntity
import zahra.hosseini.hemophiliaapp.authentication.data.RegisterRepository
import zahra.hosseini.hemophiliaapp.authentication.data.model.UserInfoEntity
import zahra.hosseini.hemophiliaapp.core.datastore.DataStoreManager
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewModel @Inject constructor(
    private val registerRepository: RegisterRepository,
    @ApplicationContext context: Context,
) :
    ViewModel() {

    private val dataStoreManager = DataStoreManager(context)

    /**
     * Insert user details
     */
    private val _response = MutableLiveData<Long>()
    val response: LiveData<Long> = _response

    //insert user details to room database
    fun insertUserDetails(userInfoEntity: UserInfoEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            _response.postValue(registerRepository.insertUserDetails(userInfoEntity))
        }
    }

    /**
     * Retrieve user details
     */

    private val _userDetails = MutableStateFlow<UserInfoEntity>(EmptyUserInfoEntity())
    val userDetails: StateFlow<UserInfoEntity> = _userDetails

    fun getUserDetails() {
        viewModelScope.launch(Dispatchers.IO) {
            registerRepository.getUserDetails()
                .catch { e ->
                    //Log error here
                    e.message.toString()
                }
                .collect {
                    _userDetails.value = it
                }
        }
    }


}