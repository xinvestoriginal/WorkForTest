package den.work.test.app

import android.app.Application
import den.work.test.app.App.Companion.cmp
import den.work.test.di.AppComponent
import den.work.test.di.DaggerAppComponent

fun di() : AppComponent = cmp!!

class App : Application() {

    companion object{
        var cmp : AppComponent? = null
    }

    override fun onCreate() {
        super.onCreate()
        cmp = DaggerAppComponent.builder().build()
    }
}