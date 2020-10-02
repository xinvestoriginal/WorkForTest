package den.work.test.di

import dagger.Module
import dagger.Provides
import den.work.test.dm.DmApi
import den.work.test.presenter.ListPresenter
import den.work.test.presenter.SendPresenter
import javax.inject.Singleton

@Module
class AppModule{

    @Singleton
    @Provides
    fun provideListPresenter(): ListPresenter = ListPresenter()


    @Singleton
    @Provides
    fun provideSendPresenter(): SendPresenter = SendPresenter()

    @Singleton
    @Provides
    fun provideDmApi(): DmApi = DmApi()

}
