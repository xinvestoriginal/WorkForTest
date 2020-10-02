package den.work.test.view

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import den.work.test.R
import den.work.test.app.di
import den.work.test.model.Post
import den.work.test.presenter.ListPresenter
import kotlinx.android.synthetic.main.activity_list.*
import javax.inject.Inject

class ListActivity : AppCompatActivity(), View.OnClickListener, IList {

    @Inject
    lateinit var presenter: ListPresenter

    init {
        di().inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        bListShowSendScreen.setOnClickListener(this)
        presenter.take(this)
    }


    override fun onConfigurationChanged(newConfig : Configuration)
    {
        super.onConfigurationChanged(newConfig)
        val adapter = rvList.adapter
        if (adapter != null) (adapter as PostAdapter).onScreenChange()
    }


    override fun onDestroy() {
        super.onDestroy()
        presenter.remove()
    }

    override fun onClick(v: View) {
        presenter.onClick(v.id)
    }

    override fun showSendScreen() {
        startActivity(Intent(this,SendActivity::class.java))
    }

    override fun setPbVisible(isVisible: Boolean) {
        pbList.visibility = if (isVisible) View.VISIBLE else View.GONE
    }

    override fun showErrorLoadPosts() {
        Toast.makeText(this,R.string.error_load_posts,Toast.LENGTH_LONG).show()
    }

    override fun fillPosts(data: ArrayList<Post>) {
        rvList.layoutManager = LinearLayoutManager(this)
        rvList.adapter = PostAdapter(data)
    }
}