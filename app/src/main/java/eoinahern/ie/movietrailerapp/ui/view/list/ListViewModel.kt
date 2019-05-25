package eoinahern.ie.movietrailerapp.ui.view.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import eoinahern.ie.movietrailerapp.data.model.MovieListEntry
import eoinahern.ie.movietrailerapp.di.PerScreen
import eoinahern.ie.movietrailerapp.domain.list.GetMovieList
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class ListViewModel @Inject constructor(private val usecase: GetMovieList) : ViewModel() {

    private val movieLiveData: MutableLiveData<Map<String, List<MovieListEntry>>> =
        MutableLiveData()

    fun getMovieList(): LiveData<Map<String, List<MovieListEntry>>> = movieLiveData

    fun getFromApi(list: List<String>) {

        usecase.setList(list)
            .execute(object : DisposableObserver<Map<String, List<MovieListEntry>>>() {
                override fun onComplete() {
                }

                override fun onNext(t: Map<String, List<MovieListEntry>>) {
                    movieLiveData.postValue(t)
                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                }
            })
    }

}