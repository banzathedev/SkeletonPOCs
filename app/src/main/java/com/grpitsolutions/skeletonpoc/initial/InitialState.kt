package com.grpitsolutions.skeletonpoc.initial

import com.grpitsolutions.core.domain.card.Card

data class InitialState(
    val cardList: List<Card> = listOf()
)