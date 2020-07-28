package com.exfaust.testforskyeng.di

import com.exfaust.testforskyeng.App
import com.exfaust.testforskyeng.ui.search.SearchViewModel
import dagger.Component

@Component(modules = [ApplicationModule::class,NetModule::class, RepositoriesModule::class])
interface AppComponent {

    fun inject(application: App)
    fun inject(searchViewModel: SearchViewModel)
}