package com.ashoks.catsapp.repository

import com.ashoks.catsapp.domain.model.Cats

interface CatsRepository {

    suspend fun search(token: String, query: String): List<Cats>


    suspend fun get(token: String, q: String): Cats
}