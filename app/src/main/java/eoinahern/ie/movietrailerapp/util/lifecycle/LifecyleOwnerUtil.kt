package eoinahern.ie.movietrailerapp.util.lifecycle

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, observer: (T) -> Unit) {
    liveData.observe(this, Observer(observer))
}