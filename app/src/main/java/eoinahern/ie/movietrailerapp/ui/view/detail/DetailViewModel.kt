package eoinahern.ie.movietrailerapp.ui.view.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import eoinahern.ie.movietrailerapp.data.model.NestedSingleMovieData
import eoinahern.ie.movietrailerapp.data.model.SingleMovieItem
import eoinahern.ie.movietrailerapp.domain.detail.GetMovieDetailUsecase
import eoinahern.ie.movietrailerapp.ui.base.BaseViewModel
import eoinahern.ie.movietrailerapp.util.exception.Failure
import io.reactivex.observers.DisposableObserver
import java.io.IOException
import javax.inject.Inject


open class DetailViewModel @Inject constructor(private val getMovieDetails: GetMovieDetailUsecase) :
    BaseViewModel() {

    private val singleMovieLiveData: MutableLiveData<NestedSingleMovieData> = MutableLiveData()

   open fun getMovieItem(): LiveData<NestedSingleMovieData> = singleMovieLiveData

    fun getSingleMovieData(movieId: String) {
        getMovieDetails.apply { setId(movieId) }
            .execute(object : DisposableObserver<NestedSingleMovieData>() {

                override fun onComplete() {
                }

                override fun onNext(movie: NestedSingleMovieData) {
                    singleMovieLiveData.value = movie
                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                    if (e is IOException) {
                        handleFailure(Failure.NetworkFailure)
                    } else {
                        handleFailure(Failure.ServerFailure)
                    }
                }
            })
    }

    override fun onCleared() {
        super.onCleared()
        getMovieDetails.clearDisposables()
    }
}