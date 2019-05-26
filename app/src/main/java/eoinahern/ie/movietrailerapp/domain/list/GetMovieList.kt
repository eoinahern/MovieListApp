package eoinahern.ie.movietrailerapp.domain.list

import eoinahern.ie.movietrailerapp.data.model.MovieListEntry
import eoinahern.ie.movietrailerapp.data.repository.list.ListRepositoryImp
import eoinahern.ie.movietrailerapp.di.PerScreen
import eoinahern.ie.movietrailerapp.domain.BaseUsecase
import eoinahern.ie.movietrailerapp.domain.repository.ListRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetMovieList @Inject constructor(private val repo: ListRepositoryImp) :
    BaseUsecase<Map<String, List<MovieListEntry>>>() {

    private lateinit var list: List<String>

    fun setList(listIn: List<String>) {
        this.list = listIn
    }

    override fun buildObservable(): Observable<Map<String, List<MovieListEntry>>> {
        return repo.getList(list)
    }
}