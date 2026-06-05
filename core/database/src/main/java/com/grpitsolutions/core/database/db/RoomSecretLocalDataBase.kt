package com.grpitsolutions.core.database.db

import com.grpitsolutions.core.database.dao.SecretDAO
import com.grpitsolutions.core.domain.card.Card
import com.grpitsolutions.core.domain.card.LocalCardDataSource

class RoomSecretLocalDataBase(
    val secretDao: SecretDAO
): LocalCardDataSource {
    override suspend fun getCard(id: Int): Card {
        TODO("Not yet implemented")
    }

    override suspend fun getAllCards() {
        TODO("Not yet implemented")
    }

    override suspend fun deleteCard(id: Int): Card {
        TODO("Not yet implemented")
    }

    override suspend fun deleteCards() {
        TODO("Not yet implemented")
    }
}