package com.grpitsolutions.skeletonpoc.initial

data class InitialState(
    val paramOne: String = "default",
    val paramTwo: List<String> = emptyList(),
)