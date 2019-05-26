package eoinahern.ie.movietrailerapp.domain.detail

import eoinahern.ie.movietrailerapp.data.model.MovieListEntry
import eoinahern.ie.movietrailerapp.di.PerScreen
import eoinahern.ie.movietrailerapp.domain.BaseUsecase
import io.reactivex.Observable
import javax.inject.Inject


class GetMovieDetailUsecase @Inject constructor() : BaseUsecase<MovieListEntry>() {

    override fun buildObservable(): Observable<MovieListEntry> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}