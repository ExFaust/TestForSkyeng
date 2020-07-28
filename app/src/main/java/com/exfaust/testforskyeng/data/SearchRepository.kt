package com.exfaust.testforskyeng.data

import com.exfaust.testforskyeng.api.TranslationApi
import com.exfaust.testforskyeng.data.model.SearchResult
import io.reactivex.Single
import javax.inject.Inject

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */

class SearchRepository @Inject constructor (private val api: TranslationApi) {


    fun search(searchText: String): Single<List<SearchResult>> {
        return api.getSearchResult(searchText)
    }

}