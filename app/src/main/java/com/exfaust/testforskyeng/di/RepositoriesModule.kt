package com.exfaust.testforskyeng.di

import com.exfaust.testforskyeng.api.TranslationApi
import com.exfaust.testforskyeng.data.SearchRepository
import dagger.Module
import dagger.Provides


@Module
class RepositoriesModule {

    @Provides
    fun provideSearchRepository(api: TranslationApi): SearchRepository {
        return SearchRepository(api)
    }
}