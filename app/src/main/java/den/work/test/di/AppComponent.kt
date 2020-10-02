package den.work.test.di


import dagger.Component
import dagger.Provides
import den.work.test.presenter.ListPresenter
import den.work.test.presenter.SendPresenter
import den.work.test.view.SendActivity
import den.work.test.view.ListActivity
import javax.inject.Singleton


@Component
interface AppComponent {
    fun inject(activity: ListActivity)
    fun inject(activity: SendActivity)
}