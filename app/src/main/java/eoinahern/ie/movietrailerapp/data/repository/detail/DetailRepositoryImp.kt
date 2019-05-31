package eoinahern.ie.movietrailerapp.data.repository.detail

import eoinahern.ie.movietrailerapp.data.model.MovieListEntry
import eoinahern.ie.movietrailerapp.data.model.SingleMovieItem
import eoinahern.ie.movietrailerapp.domain.repository.DetailRepository
import io.reactivex.Observable
import javax.inject.Inject


class DetailRepositoryImp  @Inject constructor() : DetailRepository<SingleMovieItem> {

    override fun getDetail(id: String): Observable<SingleMovieItem> {

    }
}