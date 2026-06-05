package com.grpitsolutions.core.database.keyManager

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import java.util.UUID

const val vaultName = "secure_vault_prefs"
const val dbPassword = "db_passphrase"

class DatabaseKeyManager(context: Context) {

    // create and key on Hardwarw Keystore
    private val vaultKey = MasterKey.Builder(context)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    private val sharedPreferences = EncryptedSharedPreferences.create(
        context,
        vaultName,
        vaultKey,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    fun getOrCreateDatabasePassphrase(): String {
        var passphrase = sharedPreferences.getString(dbPassword, null)
        if (passphrase == null) {
            passphrase = UUID.randomUUID().toString() + UUID.randomUUID().toString()
            sharedPreferences.edit().putString(dbPassword, passphrase).apply()
        }
        return passphrase
    }
}