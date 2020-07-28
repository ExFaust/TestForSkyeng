package com.exfaust.testforskyeng.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SearchResult(
        val text: String,
        val meanings: List<Meanings>
): Parcelable