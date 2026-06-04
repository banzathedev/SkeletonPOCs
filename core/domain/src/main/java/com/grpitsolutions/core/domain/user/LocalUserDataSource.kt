package com.grpitsolutions.core.domain.user

typealias UserID = Int

interface LocalUserDataSource {

    fun getUser(id: UserID): User

    suspend fun upsertUser(user: User)

    suspend fun deleteUser(id: UserID)

    suspend fun deleteAllUsers()
}