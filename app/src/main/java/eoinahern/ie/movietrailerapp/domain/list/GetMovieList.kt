package eoinahern.ie.movietrailerapp.domain.list

import eoinahern.ie.movietrailerapp.data.model.MovieListEntry
import eoinahern.ie.movietrailerapp.di.PerScreen
import eoinahern.ie.movietrailerapp.domain.BaseUsecase
import io.reactivex.Observable
import javax.inject.Inject


@PerScreen
class GetMovieList @Inject constructor() : BaseUsecase<List<MovieListEntry>>() {

    override fun buildObservable(): Observable<List<MovieListEntry>> {
        return Observable.just(listOf<MovieListEntry>())
    }
}