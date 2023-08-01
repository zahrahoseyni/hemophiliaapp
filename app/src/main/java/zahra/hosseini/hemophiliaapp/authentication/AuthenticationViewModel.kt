package zahra.hosseini.hemophiliaapp.authentication

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import zahra.hosseini.hemophiliaapp.authentication.data.RegisterRepository
import zahra.hosseini.hemophiliaapp.authentication.data.UserInfoEntity
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewModel @Inject constructor(private val registerRepository: RegisterRepository) :
    ViewModel() {

    val userList: LiveData<List<UserInfoEntity>> = registerRepository.allUsers

    fun getAllUsers() {
        registerRepository.getAllUsers()
    }

    fun addUser(userInfoEntity: UserInfoEntity) {
        registerRepository.addUser(userInfoEntity = userInfoEntity)
        getAllUsers()
    }

}