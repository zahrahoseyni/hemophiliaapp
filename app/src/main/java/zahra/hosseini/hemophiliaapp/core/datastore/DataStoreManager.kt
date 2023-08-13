package zahra.hosseini.hemophiliaapp.core.datastore

import android.content.Context
import androidx.datastore.preferences.createDataStore
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.preferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class DataStoreManager(context: Context) {

    private val dataStore = context.createDataStore(name = "user_prefs")

    companion object {
        val MOBILE_NUMBER = preferencesKey<String>("MOBILE_NUMBER")
        val IS_USER_LOGIN = preferencesKey<Boolean>("IS_USER_LOGIN")
        val NOTIFICATION_ID = preferencesKey<Int>("NOTIFICATION_ID")
    }

    suspend fun storeUserLogin(isLogin: Boolean) {
        dataStore.edit {
            it[IS_USER_LOGIN] = isLogin
        }
    }

    val isUserLogin: Flow<Boolean> = dataStore.data.map {
        it[IS_USER_LOGIN] ?: false
    }

    suspend fun storePhoneNumber(phoneNumber: String) {
        dataStore.edit {
            it[MOBILE_NUMBER] = phoneNumber
        }
    }

    // Create a name flow to retrieve name from the preferences
    val getPhoneNumberFlow: Flow<String> = dataStore.data.map {
        it[MOBILE_NUMBER] ?: ""
    }

    suspend fun storeNotificationId(id: Int) {
        dataStore.edit {
            it[NOTIFICATION_ID] = id
        }
    }

    val getNotificationId: Flow<Int> = dataStore.data.map {
        it[NOTIFICATION_ID] ?: 0
    }

}
