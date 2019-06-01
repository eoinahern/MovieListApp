package eoinahern.ie.movietrailerapp.ui.view.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.appbar.AppBarLayout
import eoinahern.ie.movietrailerapp.R
import eoinahern.ie.movietrailerapp.data.model.NestedSingleMovieData
import eoinahern.ie.movietrailerapp.ui.base.BaseActivity
import eoinahern.ie.movietrailerapp.util.MOVIE_ID_KEY
import eoinahern.ie.movietrailerapp.util.exception.Failure
import eoinahern.ie.movietrailerapp.util.lifecycle.failure
import eoinahern.ie.movietrailerapp.util.lifecycle.observe
import eoinahern.ie.movietrailerapp.util.view.LoadingView.State
import eoinahern.ie.movietrailerapp.util.view.setGlideImage
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject

class DetailActivity : BaseActivity() {

    private lateinit var viewModel: DetailViewModel
    private lateinit var movieItem: String

    @Inject
    lateinit var adapter: ActorsAdapter

    @Inject
    lateinit var scoresAdapter: ScoresAdapter

    @Inject
    lateinit var genreAdapter: GenreAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appBarAnimation()
        toolbarSetup()

        movieItem = intent.getStringExtra(MOVIE_ID_KEY)

        viewModel = getViewModel(DetailViewModel::class.java) {
            observe(getMovieItem(), ::updateUI)
            failure(failureLiveData, ::handleCallFailure)
        }


        getSingleMovieData()
    }

    override fun getLayout() = R.layout.activity_detail

    companion object {
        fun getStartIntent(context: Context): Intent = Intent(context, DetailActivity::class.java)
    }

    private fun toolbarSetup() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_back_24dp)
        supportActionBar?.setDisplayShowTitleEnabled(true)
    }

    /**
     * databinding might be a good option here as
     * this code looks overly verbose.
     *
     */

    private fun getSingleMovieData() {
        viewModel.getSingleMovieData(movieItem)
    }

    private fun updateUI(movieDetails: NestedSingleMovieData) {
        loading.setState(State.GONE)
        toolbar_layout.isTitleEnabled = false
        supportActionBar?.title = movieDetails.OriginalTitle
        setImage(movieDetails.images.snapshot)
        blurbText.text = movieDetails.plot
        titleText.text = movieDetails.OriginalTitle

        genresRecycler.adapter = genreAdapter
        genreAdapter.setGnereList(movieDetails.genres)

        actorsRecycler.adapter = adapter
        adapter.setList(movieDetails.actors)

        scoresAdapter.setScores(movieDetails.scores)
        scoresRecycler.adapter = scoresAdapter
    }

    private fun setImage(imageURL: String) {
        image.setGlideImage(imageURL)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                super.onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun handleCallFailure(failure: Failure) {
        when (failure) {
            Failure.ServerFailure, Failure.NetworkFailure -> {
                loading.setState(State.ERROR)
            }
        }
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
