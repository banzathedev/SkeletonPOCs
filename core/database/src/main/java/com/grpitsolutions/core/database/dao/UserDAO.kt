package com.grpitsolutions.core.database.dao

import android.R
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.grpitsolutions.core.database.entity.UserEntity

@Dao
interface UserDAO {

    @Upsert
    suspend fun upsertRun(user: UserEntity)

    @Query("SELECT * FROM userentity WHERE id=:id")
    suspend fun selectUser(id: Int): UserEntity

    @Query("DELETE FROM userentity WHERE id=:id")
    suspend fun deleteUser(id: Int)

    @Query("DELETE FROM userentity")
    suspend fun deleteAllUsers()
}