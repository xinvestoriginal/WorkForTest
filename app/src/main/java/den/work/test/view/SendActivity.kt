package den.work.test.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import den.work.test.R
import den.work.test.app.di
import den.work.test.presenter.SendPresenter
import javax.inject.Inject

class SendActivity : AppCompatActivity(), View.OnClickListener, ISend {

    @Inject
    lateinit var presenter: SendPresenter

    init {
        di().inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send)
        presenter.take(this)
    }


    override fun onDestroy() {
        super.onDestroy()
        presenter.remove()
    }

    override fun onClick(v: View) {
        presenter.onClick(v.id)
    }
}