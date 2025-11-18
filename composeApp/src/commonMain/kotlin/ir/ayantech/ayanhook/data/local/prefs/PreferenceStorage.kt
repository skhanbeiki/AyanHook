package ir.ayantech.ayanhook.data.local.prefs

interface PreferenceStorage {
    suspend fun saveString(key: String, value: String)
    suspend fun readString(key: String): String?

    suspend fun saveBoolean(key: String, value: Boolean)
    suspend fun readBoolean(key: String): Boolean?
}