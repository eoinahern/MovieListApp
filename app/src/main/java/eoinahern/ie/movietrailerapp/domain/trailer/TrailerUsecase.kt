package eoinahern.ie.movietrailerapp.domain.trailer

import eoinahern.ie.movietrailerapp.data.api.RakutenAPI
import eoinahern.ie.movietrailerapp.data.model.StreamBody
import eoinahern.ie.movietrailerapp.domain.BaseUsecase
import io.reactivex.Observable
import javax.inject.Inject


class TrailerUsecase @Inject constructor(private val api: RakutenAPI) : BaseUsecase<String>() {

    private var movieId: String = ""

    fun setMovieId(movieIdIn: String) {
        movieId = movieIdIn
    }

    override fun buildObservable(): Observable<String> {
        return api.streamMovie(StreamBody(content_id = movieId))
    }
}