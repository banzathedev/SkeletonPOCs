package com.grpitsolutions.core.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.grpitsolutions.core.database.dao.UserDAO
import com.grpitsolutions.core.database.entity.UserEntity

@Database(
    entities = [
        UserEntity::class],
    version = 1
)
abstract class UserDatabase : RoomDatabase() {

    abstract val userDao: UserDAO
}