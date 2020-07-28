package com.exfaust.testforskyeng.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Meanings(

    val id: Int,
    val previewUrl: String,
    val imageUrl: String,
    val translation: Translation,
    val transcription: String
) : Parcelable