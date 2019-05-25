package eoinahern.ie.movietrailerapp.data.repository.detail

import eoinahern.ie.movietrailerapp.data.model.MovieListEntry
import eoinahern.ie.movietrailerapp.domain.repository.DetailRepository
import io.reactivex.Observable


class DetailRepositoryImp : DetailRepository<MovieListEntry> {

    override fun getDetail(id: String): Observable<MovieListEntry> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}