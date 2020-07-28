package com.exfaust.testforskyeng.ui.searchDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.exfaust.testforskyeng.data.model.Meanings

class SearchDetailViewModel : ViewModel() {

    private val _meaning = MutableLiveData<Meanings>()
    val meaningsLiveData: LiveData<Meanings> = _meaning

    private val _word = MutableLiveData<String>()
    val wordLiveData: LiveData<String> = _word

    fun onGetArgs(meanings: Meanings, word:String){
        _meaning.value = meanings
        _word.value = word
    }
}