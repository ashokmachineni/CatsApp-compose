package com.ashoks.catsapp.repository

import com.ashoks.catsapp.domain.model.Cats
import com.ashoks.catsapp.network.model.CatsDtoMapper
import com.ashoks.catsapp.network.responses.CatsService

class CatsRepository_Impl (
    private val catsService: CatsService,
    private val mapper: CatsDtoMapper,
): CatsRepository {

    override suspend fun search(token: String, query: String): List<Cats> {
        return mapper.toDomainList(catsService.search(token = token, query = query))
    }

    override suspend fun get(token: String, q: String): Cats {
        return mapper.mapToDomainModel(catsService.get(token, q).get(0))
    }

}