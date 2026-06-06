package com.grpitsolutions.core.domain.card

interface LocalCardDataSource {

    suspend fun getCard(id: Int): Card

    suspend fun getAllCards(): List<Card>

    suspend fun deleteCard(id:Int)

    suspend fun deleteCards()
}