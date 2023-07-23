package zahra.hosseini.hemophiliaapp.core.datastore

import android.content.Context
import androidx.annotation.BoolRes
import androidx.datastore.preferences.createDataStore
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.preferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStoreManager(context: Context) {

    private val dataStore = context.createDataStore(name = "user_prefs")

    companion object {
        val MOBILE_NUMBER = preferencesKey<String>("MOBILE_NUMBER")
        val AGE = preferencesKey<String>("AGE")
        val WEIGHT = preferencesKey<String>("WEIGHT")
        val FAMILY_HISTORY = preferencesKey<Boolean>("FAMILY_HISTORY")
        val TIME_OF_DIAGNOSIS = preferencesKey<String>("TIME_OF_DIAGNOSIS")
        val SEX = preferencesKey<String>("SEX")
    }


    // Store user data
    // refer to the data store and using edit
    // we can store values using the keys
    suspend fun storeUserInfo(userInfo: UserInfo) {
        dataStore.edit {
            it[AGE] = userInfo.age
            it[WEIGHT] = userInfo.weight
            it[FAMILY_HISTORY] = userInfo.family_history
            it[TIME_OF_DIAGNOSIS] = userInfo.timeOfDiagnosis
            it[SEX] = userInfo.sex

        }
    }

    // Store user data
    // refer to the data store and using edit
    // we can store values using the keys
    suspend fun storePhoneNumber(phoneNumber: String) {
        dataStore.edit {
            it[MOBILE_NUMBER] = phoneNumber
        }
    }

    // Create a name flow to retrieve name from the preferences
    val getPhoneNumberFlow: Flow<String> = dataStore.data.map {
        it[MOBILE_NUMBER] ?: ""
    }

}