package com.grpitsolutions.core.database.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity
data class SecretEntity(
    val nameOnCard: String,
    val cardNumber: Int,
    val cardCvv: Int,
    @PrimaryKey(autoGenerate = true)
    val id: Int?
)
