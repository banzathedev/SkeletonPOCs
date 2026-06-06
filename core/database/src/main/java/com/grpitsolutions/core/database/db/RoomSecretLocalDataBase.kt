package com.grpitsolutions.core.database.db

import com.grpitsolutions.core.database.dao.SecretDAO
import com.grpitsolutions.core.database.entity.SecretEntity
import com.grpitsolutions.core.database.mappers.toDomain
import com.grpitsolutions.core.database.mappers.toEntity
import com.grpitsolutions.core.domain.card.Card
import com.grpitsolutions.core.domain.card.LocalCardDataSource

class RoomSecretLocalDataBase(
    val secretDao: SecretDAO
) : LocalCardDataSource {
    override suspend fun upsertCard(card: Card) {
        secretDao.upsertCard(card.toEntity())
    }

    override suspend fun getCard(id: Int): Card {
        return secretDao.selectCard(id).toDomain()
    }

    override suspend fun getAllCards(): List<Card> {
        return secretDao.selectAllCards().map { it.toDomain() }
    }

    override suspend fun deleteCard(id: Int) {
        secretDao.deleteCard(id)
    }

    override suspend fun deleteCards() {
        secretDao.deleteAllCards()
    }
}