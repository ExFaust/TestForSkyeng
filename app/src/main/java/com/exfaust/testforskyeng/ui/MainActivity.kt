package com.exfaust.testforskyeng.ui

import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import com.exfaust.testforskyeng.R
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable

class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
    }
}

fun SearchView.setOnQueryTextListener(): Flowable<String> {
    return Flowable.create<String>({ emitter ->
        setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
//TODO добавить поиск по клику на кнопку
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                if (newText.isNotEmpty())
                    emitter.onNext(newText)
                return true
            }
        })
    }, BackpressureStrategy.BUFFER)
}