package eoinahern.ie.movietrailerapp.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import eoinahern.ie.movietrailerapp.util.exception.Failure
import io.reactivex.Scheduler
import javax.inject.Inject


open class BaseViewModel @Inject constructor(): ViewModel() {

    var failureLiveData = MutableLiveData<Failure>()

    fun handleFailure(failure: Failure) {
        failureLiveData.value = failure
    }
}
