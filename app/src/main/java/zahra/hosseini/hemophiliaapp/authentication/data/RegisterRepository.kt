package zahra.hosseini.hemophiliaapp.authentication.data

import kotlinx.coroutines.flow.Flow
import zahra.hosseini.hemophiliaapp.authentication.data.model.UserInfoEntity
import zahra.hosseini.hemophiliaapp.core.datastore.database.AppDao

class RegisterRepository(private val appDao: AppDao) {

    //insert user details to room
    suspend fun insertUserDetails(userInfoEntity: UserInfoEntity): Long {
        return appDao.insertUserInfo(userInfoEntity)
    }

    //get single user details e.g with id 1
    fun getUserDetails(): Flow<UserInfoEntity> {
        return appDao.getUserInfo()
    }

}