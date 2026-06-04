package com.grpitsolutions.core.database.di

import androidx.room.Room
import com.grpitsolutions.core.database.db.UserDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            UserDatabase::class.java,
            "run.db"
        ).build()
    }

    single {
        get<UserDatabase>().userDao
    }
    singleOf(::RoomLocalDatasource).bind<LocalRunDataSource>()
}