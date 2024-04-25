package com.improve10x.mad

import kotlinx.serialization.Serializable

@Serializable
data class Category (
    val id: Int,
    val name: String,
    val image: String
)