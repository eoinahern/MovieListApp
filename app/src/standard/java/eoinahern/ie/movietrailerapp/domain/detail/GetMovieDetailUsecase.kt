package eoinahern.ie.movietrailerapp.domain.detail

import eoinahern.ie.movietrailerapp.data.model.NestedSingleMovieData
import eoinahern.ie.movietrailerapp.data.repository.detail.DetailRepositoryImp
import eoinahern.ie.movietrailerapp.domain.BaseUsecase
import io.reactivex.Observable
import javax.inject.Inject


class GetMovieDetailUsecase @Inject constructor(private val detailRepo: DetailRepositoryImp) :
    BaseUsecase<NestedSingleMovieData>() {

    private lateinit var id: String

    fun setId(idIn: String) {
        id = idIn
    }

    override fun buildObservable(): Observable<NestedSingleMovieData> = detailRepo.getDetail(id)
}