package eoinahern.ie.movietrailerapp.domain.trailer

import com.google.android.exoplayer2.source.ProgressiveMediaSource
import eoinahern.ie.movietrailerapp.data.api.RakutenAPI
import eoinahern.ie.movietrailerapp.data.model.StreamBody
import eoinahern.ie.movietrailerapp.data.repository.trailer.TrailerRepoImp
import eoinahern.ie.movietrailerapp.domain.BaseUsecase
import io.reactivex.Observable
import javax.inject.Inject


class TrailerUsecase @Inject constructor(private val trailerrepo: TrailerRepoImp) :
    BaseUsecase<ProgressiveMediaSource>() {

    private var movieId: String = ""

    fun setMovieId(movieIdIn: String) {
        movieId = movieIdIn
    }

    override fun buildObservable(): Observable<ProgressiveMediaSource> {
        return trailerrepo.getTrailerSource(movieId)
    }
}