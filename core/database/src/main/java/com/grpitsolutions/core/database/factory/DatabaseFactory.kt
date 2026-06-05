package com.grpitsolutions.core.database.factory

import android.content.Context
import androidx.sqlite.db.SupportSQLiteOpenHelper
import androidx.room.Room
import com.grpitsolutions.core.database.db.SecretDatabase
import net.sqlcipher.database.SupportFactory

object DatabaseFactory {

    fun create(context: Context, passwordString: String): SecretDatabase {
        // converts password from string to ByteArray (SQLCipher demands to greater safety)
        val passwordBytes = passwordString.toByteArray()
        
        val openHelperFactory: SupportSQLiteOpenHelper.Factory = SupportFactory(passwordBytes)

        return Room.databaseBuilder(
            context.applicationContext,
            SecretDatabase::class.java,
            "encrypted_secure_vault.db"
        )
        .openHelperFactory(openHelperFactory)
        .build()
    }
}