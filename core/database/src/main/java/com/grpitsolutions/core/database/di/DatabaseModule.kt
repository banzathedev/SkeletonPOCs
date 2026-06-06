package com.grpitsolutions.core.database.di

import androidx.room.Room
import com.grpitsolutions.core.database.db.RoomLocalDatasource
import com.grpitsolutions.core.database.db.RoomSecretLocalDataBase
import com.grpitsolutions.core.database.db.SecretDatabase
import com.grpitsolutions.core.database.db.UserDatabase
import com.grpitsolutions.core.database.factory.DatabaseFactory
import com.grpitsolutions.core.database.keyManager.DatabaseKeyManager
import com.grpitsolutions.core.domain.card.LocalCardDataSource
import com.grpitsolutions.core.domain.user.LocalUserDataSource
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            UserDatabase::class.java,
            "User.db"
        ).build()
    }

    single {
        get<UserDatabase>().userDao
    }
    singleOf(::RoomLocalDatasource).bind<LocalUserDataSource>()

    single { DatabaseKeyManager(androidApplication()) }

    single {
        val keyManager: DatabaseKeyManager = get()
        val vaultKey = keyManager.getOrCreateDatabasePassphrase()

        DatabaseFactory.create(
            context = androidApplication(),
            passwordString = vaultKey
        )
    }

    single { get<SecretDatabase>().secretDao }

    singleOf(::RoomSecretLocalDataBase).bind<LocalCardDataSource>()

}