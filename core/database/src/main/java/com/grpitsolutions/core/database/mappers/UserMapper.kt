package com.grpitsolutions.core.database.mappers

import com.grpitsolutions.core.database.entity.SecretEntity
import com.grpitsolutions.core.database.entity.UserEntity
import com.grpitsolutions.core.domain.card.Card
import com.grpitsolutions.core.domain.user.User

fun User.toEntity(): UserEntity {
    return UserEntity(
        name = this.name,
        age = this.age,
        documentNumber = this.document,
        id = this.id)
}

    fun UserEntity.toDomain(): User {
    return User(
        name = this.name,
        age = this.age,
        document = this.documentNumber,
        id = this.id)
}

fun SecretEntity.toDomain(): Card {
    return Card(
        nameOnCard = this.nameOnCard,
        cardNumber= this.cardNumber,
        cardCvv= this.cardCvv,
        cardID = this.id
    )
}

fun Card.toEntity(): SecretEntity {
    return SecretEntity(
        nameOnCard = this.nameOnCard,
        cardNumber = this.cardNumber,
        cardCvv = this.cardCvv,
        id = this.cardID
    )
}