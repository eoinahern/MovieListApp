package eoinahern.ie.movietrailerapp.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class ViewModelFactory @Inject constructor(private val vmMap: MutableMap<Class<out ViewModel>, @JvmSuppressWildcards Provider<out ViewModel>>) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T = vmMap[modelClass]?.get() as T

}