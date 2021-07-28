package com.ashoks.catsapp.di

import com.ashoks.catsapp.network.model.CatsDtoMapper
import com.ashoks.catsapp.network.responses.CatsService
import com.ashoks.catsapp.repository.CatsRepository
import com.ashoks.catsapp.repository.CatsRepository_Impl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRecipeRepository(
        catsService: CatsService,
        catsMapper: CatsDtoMapper,
    ): CatsRepository {
        return CatsRepository_Impl(
            catsService = catsService,
            mapper = catsMapper
        )
    }
}

