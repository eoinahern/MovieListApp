package eoinahern.ie.movietrailerapp.domain.repository

import io.reactivex.Observable


interface TrailerRepo<T> {
    fun getTrailerSource(id: String): Observable<T>
}