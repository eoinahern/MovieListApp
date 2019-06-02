package eoinahern.ie.movietrailerapp.data.repository.trailer

import com.google.android.exoplayer2.source.ProgressiveMediaSource
import io.reactivex.Observable

interface TrailerDataSource {
    fun getTrailerItem(movieId :String) : Observable<ProgressiveMediaSource>
}