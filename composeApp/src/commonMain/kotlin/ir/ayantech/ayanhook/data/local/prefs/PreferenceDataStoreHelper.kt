package ir.ayantech.ayanhook.data.local.prefs

class PreferenceDataStoreHelper(val storage: PreferenceStorage) {
    suspend fun saveString(key: String, value: String) = storage.saveString(key, value)
    suspend fun readString(key: String): String? = storage.readString(key)

    suspend fun saveBoolean(key: String, value: Boolean) = storage.saveBoolean(key, value)
    suspend fun readBoolean(key: String): Boolean? = storage.readBoolean(key)
}