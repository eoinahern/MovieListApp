package eoinahern.ie.movietrailerapp.domain.detail

import eoinahern.ie.movietrailerapp.data.model.MovieListEntry
import eoinahern.ie.movietrailerapp.domain.BaseUsecase
import io.reactivex.Observable


class GetMovieDetailUsecase : BaseUsecase<MovieListEntry>() {


    override fun buildObservable(): Observable<MovieListEntry> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}