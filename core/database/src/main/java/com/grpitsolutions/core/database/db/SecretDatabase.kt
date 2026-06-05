package com.grpitsolutions.core.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.grpitsolutions.core.database.dao.SecretDAO
import com.grpitsolutions.core.database.entity.SecretEntity

@Database(
    entities = [
        SecretEntity::class
    ],
    version = 1
)

abstract class SecretDatabase: RoomDatabase() {

    abstract class secretDao: SecretDAO
}