package eoinahern.ie.movietrailerapp.ui.view.trailer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import eoinahern.ie.movietrailerapp.domain.trailer.TrailerUsecase
import eoinahern.ie.movietrailerapp.ui.base.BaseViewModel
import eoinahern.ie.movietrailerapp.util.exception.Failure
import io.reactivex.observers.DisposableObserver
import java.io.IOException
import javax.inject.Inject


class TrailerViewModel @Inject constructor(private val trailerUsecase: TrailerUsecase) :
    BaseViewModel() {

    private val datasourceLiveData: MutableLiveData<ProgressiveMediaSource> = MutableLiveData()

    fun getDataSource(): LiveData<ProgressiveMediaSource> {
        return datasourceLiveData
    }

    fun loadTrailer(id: String) {

        trailerUsecase.apply { setMovieId(id) }
            .execute(object : DisposableObserver<ProgressiveMediaSource>() {
                override fun onComplete() {}

                override fun onNext(mediaSource: ProgressiveMediaSource) {
                    datasourceLiveData.value = mediaSource
                }

                override fun onError(e: Throwable) {
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
        trailerUsecase.clearDisposables()
    }

}