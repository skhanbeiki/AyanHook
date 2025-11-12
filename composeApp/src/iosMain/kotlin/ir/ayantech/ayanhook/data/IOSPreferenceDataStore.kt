package ir.ayantech.ayanhook.data


import com.russhwolf.settings.Settings
import ir.ayantech.ayanhook.utils.dataStore.PreferenceStorage

class IOSPreferenceDataStore : PreferenceStorage {
    private val settings = Settings()

    override suspend fun saveString(key: String, value: String) {
        settings.putString(key, value)
    }

    override suspend fun readString(key: String): String? {
        return settings.getStringOrNull(key)
    }

    override suspend fun saveBoolean(key: String, value: Boolean) {
        settings.putBoolean(key, value)
    }

    override suspend fun readBoolean(key: String): Boolean? {
        return settings.getBooleanOrNull(key)
    }
}
