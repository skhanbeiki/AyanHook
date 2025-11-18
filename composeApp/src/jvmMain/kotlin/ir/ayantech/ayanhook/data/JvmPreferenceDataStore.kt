package ir.ayantech.ayanhook.data

import java.util.prefs.Preferences
import ir.ayantech.ayanhook.data.local.prefs.PreferenceStorage

class JvmPreferenceDataStore : PreferenceStorage {
    private val prefs = Preferences.userRoot().node("AyanHookPrefs")

    override suspend fun saveString(key: String, value: String) {
        prefs.put(key, value)
    }

    override suspend fun readString(key: String): String? {
        return prefs.get(key, null)
    }

    override suspend fun saveBoolean(key: String, value: Boolean) {
        prefs.putBoolean(key, value)
    }

    override suspend fun readBoolean(key: String): Boolean? {
        return if (prefs.keys().contains(key)) prefs.getBoolean(key, false) else null
    }
}