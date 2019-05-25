package eoinahern.ie.movietrailerapp.data.repository.detail

import eoinahern.ie.movietrailerapp.data.model.MovieListEntry
import io.reactivex.Observable


interface DetailsDataSource {
    fun getDetailItem(id: String): Observable<MovieListEntry>
}