package eoinahern.ie.movietrailerapp.ui.view.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import eoinahern.ie.movietrailerapp.data.model.SingleMovieItem
import eoinahern.ie.movietrailerapp.domain.detail.GetMovieDetailUsecase
import eoinahern.ie.movietrailerapp.ui.base.BaseViewModel
import javax.inject.Inject


class DetailViewModel @Inject constructor(private val getMovieDetails: GetMovieDetailUsecase) :
    BaseViewModel() {


    private val singleMovieLiveData: MutableLiveData<SingleMovieItem> = MutableLiveData()

    fun getMovieItem(): LiveData<SingleMovieItem> = singleMovieLiveData

    fun getSingleMovieData() {

    }


}