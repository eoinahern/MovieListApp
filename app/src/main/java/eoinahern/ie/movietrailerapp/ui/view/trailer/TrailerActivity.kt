package eoinahern.ie.movietrailerapp.ui.view.trailer

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.google.android.exoplayer2.SimpleExoPlayer
import dagger.android.AndroidInjection
import eoinahern.ie.movietrailerapp.R
import eoinahern.ie.movietrailerapp.ui.base.BaseActivity
import eoinahern.ie.movietrailerapp.util.MOVIE_ID_KEY
import kotlinx.android.synthetic.main.activity_trailer.*
import javax.inject.Inject
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.util.Util.getUserAgent
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory

import android.net.Uri
import android.view.MenuItem
import android.view.View
import eoinahern.ie.movietrailerapp.util.exception.Failure
import eoinahern.ie.movietrailerapp.util.lifecycle.failure
import eoinahern.ie.movietrailerapp.util.lifecycle.observe


class TrailerActivity : BaseActivity() {

    @Inject
    lateinit var exoPlayer: SimpleExoPlayer

    private lateinit var viewModel: TrailerViewModel

    private lateinit var movieId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setActionBar()

        movieId = intent.getStringExtra(MOVIE_ID_KEY)

        viewModel = getViewModel(TrailerViewModel::class.java) {
            observe(getDataSource(), ::setExoPlayer)
            failure(failureLiveData, ::handleFailure)
        }

        getTrailerData(movieId)
    }

    private fun setActionBar() {
        setSupportActionBar(toolabr)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_back_24dp)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.trailerTxtLower)
    }

    private fun getTrailerData(id: String) {
        viewModel.loadTrailer(id)
    }

    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, TrailerActivity::class.java)
        }
    }

    private fun setExoPlayer(videoSource: ProgressiveMediaSource) {
        player_view.player = exoPlayer

        exoPlayer.prepare(videoSource)
        exoPlayer.playWhenReady = true
    }

    private fun handleFailure(failure: Failure) {
        when (failure) {
            is Failure.NetworkFailure, Failure.ServerFailure -> {
                error.visibility = View.VISIBLE
            }
        }
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

    override fun getLayout() = R.layout.activity_trailer

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        exoPlayer.release()
    }
}
