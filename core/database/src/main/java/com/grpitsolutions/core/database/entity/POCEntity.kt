package com.grpitsolutions.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/* Annotation to define this class as an entity for room **/
@Entity
data class UserEntity(
    val name: String,
    val age: Int,
    val documentNumber: Int,
    @PrimaryKey(autoGenerate = true)
    val id: Int
)
