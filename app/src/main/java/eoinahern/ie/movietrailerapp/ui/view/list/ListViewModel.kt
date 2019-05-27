package eoinahern.ie.movietrailerapp.ui.view.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import eoinahern.ie.movietrailerapp.data.model.MovieListEntry
import eoinahern.ie.movietrailerapp.domain.list.GetMovieList
import eoinahern.ie.movietrailerapp.ui.base.BaseViewModel
import eoinahern.ie.movietrailerapp.util.exception.Failure
import io.reactivex.observers.DisposableObserver
import java.io.IOException
import javax.inject.Inject


class ListViewModel @Inject constructor(
    private val usecase: GetMovieList
) : BaseViewModel() {

    private val movieLiveData: MutableLiveData<Map<String, List<MovieListEntry>>> = MutableLiveData()

    fun getMovieList(): LiveData<Map<String, List<MovieListEntry>>> = movieLiveData

    fun getFromApi(list: List<String>) {

        usecase.apply { setList(list) }
            .execute(object : DisposableObserver<Map<String, List<MovieListEntry>>>() {
                override fun onComplete() {
                }

                override fun onNext(t: Map<String, List<MovieListEntry>>) {
                    movieLiveData.value = t
                }

                override fun onError(e: Throwable) {
                    if (e is IOException) handleFailure(Failure.NetworkFailure)
                    else handleFailure(Failure.ServerFailure)
                }
            })
    }


}