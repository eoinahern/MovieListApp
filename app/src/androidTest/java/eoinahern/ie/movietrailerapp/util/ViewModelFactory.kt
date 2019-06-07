package eoinahern.ie.movietrailerapp.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import eoinahern.ie.movietrailerapp.ui.view.all.AllSectionViewModel
import eoinahern.ie.movietrailerapp.ui.view.detail.DetailViewModel
import org.mockito.Mockito.mock
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton


@Singleton
class ViewModelFactory @Inject constructor(val map: MutableMap<Class<out ViewModel>, Provider<ViewModel>>) :
    ViewModelProvider.Factory {

    init {

    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return mock(DetailViewModel::class.java) as T
        } else if (modelClass.isAssignableFrom(AllSectionViewModel::class.java)) {
            return mock(AllSectionViewModel::class.java) as T
        } else {
            return mock(ViewModel::class.java) as T
        }
    }


}