package com.ashoks.catsapp.network.responses

import com.ashoks.catsapp.network.model.CatsDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CatsService {

    @GET("breeds/")
    suspend fun search(
        @Header("x-api-key") token: String,
        @Query("q") query: String,
    ): ArrayList<CatsDto>

    @GET("breeds/search/")
    suspend fun get(
        @Header("x-api-key") token: String,
        @Query("q") id: String
    ): ArrayList<CatsDto>
}
