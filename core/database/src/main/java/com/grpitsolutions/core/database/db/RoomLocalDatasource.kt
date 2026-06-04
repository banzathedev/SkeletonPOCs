package com.grpitsolutions.core.database.db

import android.database.sqlite.SQLiteFullException
import com.grpitsolutions.core.database.dao.UserDAO
import com.grpitsolutions.core.database.mappers.toDomain
import com.grpitsolutions.core.database.mappers.toEntity
import com.grpitsolutions.core.domain.user.LocalUserDataSource
import com.grpitsolutions.core.domain.user.User
import com.grpitsolutions.core.domain.user.UserID
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RoomLocalDatasource (
    private val userDao: UserDAO
) : LocalUserDataSource {
    override  suspend fun getUser(id: UserID): User {
        return userDao.selectUser(id).toDomain()
    }

    override suspend fun upsertUser(user: User) {
        userDao.upsertRun(user.toEntity())
    }

    override suspend fun deleteUser(id: UserID) {
       userDao.selectUser(id)
    }

    override suspend fun deleteAllUsers() {
       userDao.deleteAllUsers()
    }
}