package com.grpitsolutions.core.database.mappers

import com.grpitsolutions.core.database.entity.UserEntity
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