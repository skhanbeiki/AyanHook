package ir.ayantech.ayanhook.data.datasource.local.preferences

import platform.Foundation.NSUserDefaults

class IOSPreferenceStorage : PreferenceStorage {

    private val defaults: NSUserDefaults = NSUserDefaults.standardUserDefaults()

    override suspend fun saveString(key: String, value: String) {
        // setObject expects NSString, Kotlin String is bridged automatically
        defaults.setObject(value, forKey = key)
        defaults.synchronize()
    }

    override suspend fun readString(key: String): String? {
        val value = defaults.stringForKey(key)
        return value // may be null
    }

    override suspend fun saveBoolean(key: String, value: Boolean) {
        defaults.setBool(value, forKey = key)
        defaults.synchronize()
    }

    override suspend fun readBoolean(key: String): Boolean? {
        // If key not present, boolForKey returns false — we need to detect absence.
        val objectVal = defaults.objectForKey(key)
        return if (objectVal == null) null else defaults.boolForKey(key)
    }
}