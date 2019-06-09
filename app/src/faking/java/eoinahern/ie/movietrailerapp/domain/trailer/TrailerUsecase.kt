package eoinahern.ie.movietrailerapp.domain.trailer

import android.content.Context
import android.net.Uri
import com.google.android.exoplayer2.extractor.ExtractorsFactory
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import eoinahern.ie.movietrailerapp.R
import eoinahern.ie.movietrailerapp.domain.BaseUsecase
import io.reactivex.Observable
import javax.inject.Inject

class TrailerUsecase @Inject constructor(context: Context) : BaseUsecase<ProgressiveMediaSource>() {

    private val defDataSource = DefaultDataSourceFactory(
        context,
        Util.getUserAgent(context, context.resources.getString(R.string.app_name))
    )

    fun setMovieId(movieIdIn: String) {
        //dont need to do anything here
    }

    override fun buildObservable(): Observable<ProgressiveMediaSource> {
        return Observable.just(
            ProgressiveMediaSource.Factory(defDataSource)
                .createMediaSource(Uri.parse("www.google.com"))
        )
    }


}