package eoinahern.ie.movietrailerapp.data.repository.trailer

import com.google.android.exoplayer2.source.ProgressiveMediaSource
import eoinahern.ie.movietrailerapp.domain.repository.TrailerRepo
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TrailerRepoImp @Inject constructor(val factory: TrailerDataSourceFactory) :
    TrailerRepo<ProgressiveMediaSource> {

    override fun getTrailerSource(id: String): Observable<ProgressiveMediaSource> {
        return factory.getDataSource().getTrailerItem(id)
    }
}