package den.work.test.presenter

import dagger.Provides
import den.work.test.R
import den.work.test.app.di
import den.work.test.dm.DmApi
import den.work.test.model.Post
import den.work.test.view.IList
import kotlinx.android.synthetic.main.activity_list.view.*
import javax.inject.Inject
import javax.inject.Singleton



class ListPresenter @Inject constructor(): IPresenter, DmApi.IPostsLoad {

    @Inject
    lateinit var api : DmApi

    private var view : IList? = null

    override fun take(v: Any) {
        view = v as IList
        view?.setPbVisible(true)
        api.loadPosts(this)
    }

    override fun remove() {
        view = null
    }

    override fun onClick(id: Int) {
        when(id){
            R.id.bListShowSendScreen -> view?.showSendScreen()
        }
    }

    override fun onPostData(data: ArrayList<Post>?) {
        view?.setPbVisible(false)
        if (data == null){
            view?.showErrorLoadPosts()
        }else{
            view?.fillPosts(data!!)
        }
    }
}