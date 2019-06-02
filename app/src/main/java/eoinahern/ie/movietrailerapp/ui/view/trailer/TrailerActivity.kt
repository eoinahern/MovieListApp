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
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.util.Util.getUserAgent
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory

import android.net.Uri


class TrailerActivity : BaseActivity() {

    @Inject
    lateinit var exoPlayer: SimpleExoPlayer

    private lateinit var movieId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setExoPlayer()
        setActionBar()

        movieId = intent.getStringExtra(MOVIE_ID_KEY)
    }

    private fun setActionBar() {
        setSupportActionBar(toolabr)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_back_24dp)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Trailer"
    }


    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, TrailerActivity::class.java)
        }
    }

    private fun setExoPlayer() {
        player_view.player = exoPlayer

        val dataSourceFactory = DefaultDataSourceFactory(
            this, getUserAgent(this, getString(R.string.app_name))
        )


        val videoSource = ProgressiveMediaSource.Factory(dataSourceFactory)
            .createMediaSource(Uri.parse("https://prod-stpeter-pmd.akamai.cdn.rakuten.tv/4/4/b/44bfec568604ddfc6c6b8dd602cc6a7a-mc-0-128-0-0_SD_TRAILER_PAR_1_1/44bfec568604ddfc6c6b8dd602cc6a7a-mc-0-128-0-0_SD_TRAILER_PAR_1_1.mp4?token=st=1559464356~exp=1559485956~acl=*/4/4/b/44bfec568604ddfc6c6b8dd602cc6a7a-mc-0-128-0-0_SD_TRAILER_PAR_1_1/44bfec568604ddfc6c6b8dd602cc6a7a-mc-0-128-0-0_SD_TRAILER_PAR_1_1.mp4*~hmac=e43f6e78381db09441e82a1b0dda6133dc52a479fc68610ed2dbaf89ffe54486"))


        exoPlayer.prepare(videoSource)
        exoPlayer.playWhenReady = true
    }

    override fun getLayout() = R.layout.activity_trailer


    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        exoPlayer.release()
    }

    override fun onPause() {
        super.onPause()
        exoPlayer.release()
    }
}
