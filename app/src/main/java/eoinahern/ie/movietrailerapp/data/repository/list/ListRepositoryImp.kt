package eoinahern.ie.movietrailerapp.data.repository.list

import eoinahern.ie.movietrailerapp.data.model.MovieListEntry
import eoinahern.ie.movietrailerapp.domain.repository.ListRepository
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ListRepositoryImp @Inject constructor(private val factory: ListDataSourceFactory) :
    ListRepository<Map<String, List<MovieListEntry>>> {

    override fun getList(list: List<String>): Observable<Map<String, List<MovieListEntry>>> =
        factory.getDataSource().getList(list)
}