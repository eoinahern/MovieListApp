package eoinahern.ie.movietrailerapp.domain.repository

import io.reactivex.Observable

interface ListRepository<T> {
    fun getList(list : List<String>): Observable<T>
}