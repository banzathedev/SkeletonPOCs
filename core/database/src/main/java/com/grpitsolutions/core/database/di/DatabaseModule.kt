package com.grpitsolutions.core.database.di

import androidx.room.Room
import com.grpitsolutions.core.database.db.RoomLocalDatasource
import com.grpitsolutions.core.database.db.UserDatabase
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



}