package eoinahern.ie.movietrailerapp.ui.view.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.google.android.material.appbar.AppBarLayout
import eoinahern.ie.movietrailerapp.R
import eoinahern.ie.movietrailerapp.data.model.NestedSingleMovieData
import eoinahern.ie.movietrailerapp.ui.base.BaseActivity
import eoinahern.ie.movietrailerapp.util.MOVIE_ID_KEY
import eoinahern.ie.movietrailerapp.util.exception.Failure
import eoinahern.ie.movietrailerapp.util.lifecycle.failure
import eoinahern.ie.movietrailerapp.util.lifecycle.observe
import eoinahern.ie.movietrailerapp.util.view.updateOpacityVal
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseActivity() {

    private lateinit var viewModel: DetailViewModel
    val movieItem = intent.getStringExtra(MOVIE_ID_KEY)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appBarAnimation()
        toolbarSetup()

        viewModel = getViewModel(DetailViewModel::class.java) {
            observe(getMovieItem(), ::updateUI)
            failure(failureLiveData, ::handleFailure)
        }
    }

    override fun getLayout() = R.layout.activity_detail

    companion object {
        fun getStartIntent(context: Context): Intent = Intent(context, DetailActivity::class.java)
    }

    private fun toolbarSetup() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_back_24dp)
    }


    private fun updateUI(movieDetails: NestedSingleMovieData) {

    }

    private fun handleFailure(failure: Failure) {

    }

    private fun appBarAnimation() {
        appbar.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
            var scrollRange = -1
            override fun onOffsetChanged(appBar: AppBarLayout?, offset: Int) {
                if (scrollRange == -1)
                    scrollRange = appBar?.totalScrollRange ?: 0

                val percent = Math.abs(offset) / scrollRange.toFloat()
                toolbar.alpha = percent
                image.alpha = 1.00f - percent
            }
        })
    }
}
