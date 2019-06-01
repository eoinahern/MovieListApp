package eoinahern.ie.movietrailerapp.data.repository.detail

import eoinahern.ie.movietrailerapp.data.model.MovieListEntry
import eoinahern.ie.movietrailerapp.data.model.NestedSingleMovieData
import eoinahern.ie.movietrailerapp.data.model.SingleMovieItem
import eoinahern.ie.movietrailerapp.domain.repository.DetailRepository
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DetailRepositoryImp @Inject constructor(private val factory: DetailDataSourceFactory) :
    DetailRepository<NestedSingleMovieData> {

    override fun getDetail(id: String): Observable<NestedSingleMovieData> {
        return factory.getDataSource().getDetailItem(id)
    }
}