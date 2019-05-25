package eoinahern.ie.movietrailerapp.data.repository.list

import eoinahern.ie.movietrailerapp.data.model.MovieListEntry
import io.reactivex.Observable

interface ListDataSource {
    fun getList(list: List<String>): Observable<Map<String, List<MovieListEntry>>>
}