package com.grpitsolutions.core.domain.card

interface LocalCardDataSource {

    suspend fun getCard(id: Int): Card

    suspend fun getAllCards()

    suspend fun deleteCard(id:Int): Card

    suspend fun deleteCards()
}