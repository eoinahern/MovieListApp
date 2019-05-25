package eoinahern.ie.movietrailerapp.domain.repository

import io.reactivex.Observable


interface DetailRepository<T> {
    fun getDetail(id: String): Observable<T>
}