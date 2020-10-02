package den.work.test.view

import den.work.test.model.Post

interface IList {
    fun showSendScreen()
    fun setPbVisible(isVisible: Boolean)
    fun showErrorLoadPosts()
    fun fillPosts(data: ArrayList<Post>)
}