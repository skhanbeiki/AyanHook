package ir.ayantech.ayanhook.data

import kotlinx.browser.localStorage
import ir.ayantech.ayanhook.utils.dataStore.PreferenceStorage

class JsPreferenceDataStore : PreferenceStorage {
    override suspend fun saveString(key: String, value: String) {
        localStorage.setItem(key, value)
    }

    override suspend fun readString(key: String): String? {
        return localStorage.getItem(key)
    }

    override suspend fun saveBoolean(key: String, value: Boolean) {
        localStorage.setItem(key, value.toString())
    }

    override suspend fun readBoolean(key: String): Boolean? {
        return localStorage.getItem(key)?.toBooleanStrictOrNull()
    }
}