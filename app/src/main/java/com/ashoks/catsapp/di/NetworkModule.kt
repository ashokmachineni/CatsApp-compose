package com.ashoks.catsapp.di

import com.ashoks.catsapp.network.model.CatsDtoMapper
import com.ashoks.catsapp.network.responses.CatsService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRecipeMapper(): CatsDtoMapper {
        return CatsDtoMapper()
    }

    @Singleton
    @Provides
    fun provideRecipeService(): CatsService {
        return Retrofit.Builder()
            .baseUrl("https://api.thecatapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(CatsService::class.java)
    }


    @Singleton
    @Provides
    @Named("auth_token")
    fun provideAuthToken(): String{
        return "9ddfcf19-1e0a-40c7-9b19-5c60ef4b8582"
    }

}