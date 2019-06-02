package eoinahern.ie.movietrailerapp.data.repository.trailer

import android.net.Uri
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import eoinahern.ie.movietrailerapp.data.api.RakutenAPI
import io.reactivex.Observable


class TrailerNetworkDataSource constructor(
    private val api: RakutenAPI,
    private val defaultDataSource: DefaultDataSourceFactory
) : TrailerDataSource {


    override fun getTrailerItem(movieId: String): Observable<ProgressiveMediaSource> {
        return api.streamMovie(movieId).map {
            ProgressiveMediaSource.Factory(defaultDataSource)
                .createMediaSource(Uri.parse(it.data.stream_infos[0].url))
        }
    }


}