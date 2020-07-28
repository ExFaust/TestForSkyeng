package com.exfaust.testforskyeng.api

import com.exfaust.testforskyeng.data.model.SearchResult
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface TranslationApi {

    @GET("words/search")
    fun getSearchResult(@Query (ApiConstants.SEARCH)search:String): Single<List<SearchResult>>
}