package eoinahern.ie.movietrailerapp.ui.view.trailer

import eoinahern.ie.movietrailerapp.domain.trailer.TrailerUsecase
import eoinahern.ie.movietrailerapp.ui.base.BaseViewModel
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject


class TrailerViewModel @Inject constructor(private val trailerUsecase: TrailerUsecase) :
    BaseViewModel() {


    /*fun loadTrailer(id: String) {

        trailerUsecase.apply { setMovieId(id) }.execute(object : DisposableObserver<String>() {
            override fun onComplete() {}

            override fun onNext(t: String) {
            }

            override fun onError(e: Throwable) {
            }


        })

    }*/

}