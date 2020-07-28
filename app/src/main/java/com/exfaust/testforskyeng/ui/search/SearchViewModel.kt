package com.exfaust.testforskyeng.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.exfaust.testforskyeng.App
import com.exfaust.testforskyeng.data.SearchRepository
import com.exfaust.testforskyeng.data.model.Meanings
import com.exfaust.testforskyeng.data.model.Events
import com.exfaust.testforskyeng.utils.NetHelper
import com.exfaust.testforskyeng.utils.NoConnectivityException
import com.exfaust.testforskyeng.utils.SingleNetworkEvent
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SearchViewModel : ViewModel() {

    @Inject
    lateinit var searchRepository: SearchRepository

    @Inject
    lateinit var netHelper: NetHelper

    init {
        App.instance.getAppComponent().inject(this)
    }

    private val _searchResult = MutableLiveData<List<Meanings>>()
    val searchResult: LiveData<List<Meanings>> = _searchResult

    private val _search = MutableLiveData<String>()
    val search: LiveData<String> = _search

    private val eventListener: MediatorLiveData<SingleNetworkEvent> =
        MediatorLiveData()

    fun onEvent(): LiveData<SingleNetworkEvent> {
        return eventListener
    }

    fun onSearchChanged(flowable: Flowable<String>) {
        flowable
            .doOnNext {
                _search.value = it
                eventListener.value = SingleNetworkEvent(Events.LOADING)
            }
            .debounce(1, TimeUnit.SECONDS)
            .distinctUntilChanged()
            .switchMapSingle {text:String ->
                netHelper.checkConnection()
                    .filter { it }
                    .flatMapSingle { searchRepository.search(text) }//TODO добавить обработку очищения поля ввода
                    .flatMapPublisher {Flowable.fromIterable(it)}
                    .map { it.meanings }
                    .flatMapIterable { it }
                    .toList()
            }
            .subscribeOn(Schedulers.single())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError {
                if (it is NoConnectivityException)
                    eventListener.value = SingleNetworkEvent(Events.NO_CONNECTIVITY)
                else
                    eventListener.value = SingleNetworkEvent(Events.ERROR)
            }
            .onErrorResumeNext(Flowable.never())
            .doOnNext {
                _searchResult.value = it
                if (it.isEmpty())
                    eventListener.value = SingleNetworkEvent(Events.NOT_FOUND)
                else
                    eventListener.value = SingleNetworkEvent(Events.SUCCESS)
            }
            .subscribe()
    }
}
