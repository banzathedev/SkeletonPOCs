package com.grpitsolutions.core.database.db

import android.database.sqlite.SQLiteFullException
import com.grpitsolutions.core.database.dao.UserDAO
import com.grpitsolutions.core.domain.user.LocalUserDataSource
import com.grpitsolutions.core.domain.user.User
import com.grpitsolutions.core.domain.user.UserID
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RoomLocalDatasource (
    private val userDao: UserDAO
) : LocalUserDataSource {
    override fun getUser(id: UserID): User {
        TODO("Not yet implemented")
    }

    override suspend fun upsertUser(user: User) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteUser(id: UserID) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAllUsers() {
        TODO("Not yet implemented")
    }

}