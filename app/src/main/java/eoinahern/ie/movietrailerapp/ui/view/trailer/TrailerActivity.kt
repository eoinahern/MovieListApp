package eoinahern.ie.movietrailerapp.ui.view.trailer

import android.os.Bundle
import com.google.android.exoplayer2.SimpleExoPlayer
import dagger.android.AndroidInjection
import eoinahern.ie.movietrailerapp.R
import eoinahern.ie.movietrailerapp.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_trailer.*
import javax.inject.Inject

class TrailerActivity : BaseActivity() {

    @Inject
    lateinit var exoPlayer: SimpleExoPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trailer)
        setExoPlayer()
        setActionBar()
    }

    fun setActionBar() {
        setSupportActionBar(toolabr)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_back_24dp)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Trailer"

    }

    private fun setExoPlayer() {
        player_view.player = exoPlayer
    }

    override fun getLayout() = R.layout.activity_trailer
}
