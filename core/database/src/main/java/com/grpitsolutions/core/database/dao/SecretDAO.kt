package com.grpitsolutions.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.grpitsolutions.core.database.entity.SecretEntity
import com.grpitsolutions.core.domain.card.Card

@Dao
interface SecretDAO {
   @Upsert
   suspend fun upsertCard(card: Card)

    @Query("SELECT * FROM secretentity WHERE id=id")
    suspend fun selectCard(id: Int): SecretEntity

    @Query("DELETE FROM secretentity WHERE id=:id")
    suspend fun deleteCard(id: Int)

    @Query("DELETE FROM secretentity")
    suspend fun deleteAllCards()

    @Query("SELECT * FROM secretentity")
    suspend fun selectAllCards(): List<SecretEntity>
}