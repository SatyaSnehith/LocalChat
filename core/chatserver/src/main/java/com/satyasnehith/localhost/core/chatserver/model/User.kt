package com.satyasnehith.localhost.core.chatserver.model

import kotlinx.serialization.Serializable

@Serializable
class User(
    val username: String,
    val password: String
)