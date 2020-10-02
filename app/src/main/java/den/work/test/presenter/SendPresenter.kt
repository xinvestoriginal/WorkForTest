package den.work.test.presenter


import den.work.test.view.ISend
import javax.inject.Inject
import javax.inject.Singleton


class SendPresenter @Inject constructor(): IPresenter {

    private var view : ISend? = null


    override fun take(v: Any) {
        view = v as ISend
    }

    override fun remove() {
        view = null
    }

    override fun onClick(id: Int) {

    }
}