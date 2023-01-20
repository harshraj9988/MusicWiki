package com.example.musicwiki.dependency_injection

import com.example.musicwiki.network.LastFMService
import com.example.musicwiki.presentation.BaseApplication
import com.example.musicwiki.repository.LastFMRepository
import com.example.musicwiki.repository.LastFMRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideLastFMRepository(
        lastFMService: LastFMService
    ): LastFMRepository {
        return LastFMRepositoryImpl(
            lastFMService
        )
    }
}
