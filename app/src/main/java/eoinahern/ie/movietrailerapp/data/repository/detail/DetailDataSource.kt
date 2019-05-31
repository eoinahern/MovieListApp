package eoinahern.ie.movietrailerapp.data.repository.detail

import eoinahern.ie.movietrailerapp.data.model.MovieListEntry
import eoinahern.ie.movietrailerapp.data.model.NestedSingleMovieData
import eoinahern.ie.movietrailerapp.data.model.SingleMovieItem
import io.reactivex.Observable


interface DetailsDataSource {
    fun getDetailItem(id: String): Observable<NestedSingleMovieData>
}