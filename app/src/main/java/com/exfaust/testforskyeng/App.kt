package com.exfaust.testforskyeng

import android.app.Application
import com.exfaust.testforskyeng.di.*

class App : Application(){

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()

        instance = this
        setup()
    }

    fun setup() {
        component = DaggerAppComponent.builder()
            .applicationModule(ApplicationModule(this))
            .netModule(NetModule())
            .repositoriesModule(RepositoriesModule())
            .build()
        component.inject(this)
    }

    fun getAppComponent(): AppComponent {
        return component
    }

    companion object {
        lateinit var instance: App private set
    }
}