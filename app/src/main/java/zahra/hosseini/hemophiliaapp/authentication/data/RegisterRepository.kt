package zahra.hosseini.hemophiliaapp.authentication.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import zahra.hosseini.hemophiliaapp.core.datastore.database.AppDao

class RegisterRepository(private val appDao: AppDao) {

    val allUsers = MutableLiveData<List<UserInfoEntity>>()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun addUser(userInfoEntity: UserInfoEntity) {
        coroutineScope.launch(Dispatchers.IO) {
            appDao.insertUserInfo(userInfoEntity)
        }
    }

    fun getAllUsers() {
        coroutineScope.launch(Dispatchers.IO) {
            allUsers.postValue(appDao.getAllUser())
            allUsers.value?.get(0)?.sex?.let { Log.d("dfkjbdgvd", it) }

        }
    }

}