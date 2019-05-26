package eoinahern.ie.movietrailerapp.util.lifecycle

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import eoinahern.ie.movietrailerapp.util.exception.Failure

fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, observer: (T) -> Unit) {
    liveData.observe(this, Observer(observer))
}

fun <T : Failure, L : LiveData<T>> LifecycleOwner.failure(livedata: L, localObserver: (T) -> Unit) {
    livedata.observe(this, Observer(localObserver))
}