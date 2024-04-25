package com.improve10x.mad

import io.ktor.client.call.body
import io.ktor.client.request.get

class CategoryRepository {

    suspend fun getCategories(): List<Category> {
        val response = KtorClient.httpClient
            .get("https://api.escuelajs.co/api/v1/categories")
            .body<List<Category>>()
        return response
    }

}