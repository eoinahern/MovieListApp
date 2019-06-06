package eoinahern.ie.movietrailerapp.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import eoinahern.ie.movietrailerapp.ui.view.all.MockAllViewmodel
import eoinahern.ie.movietrailerapp.ui.view.detail.MockDetailViewModel


import eoinahern.ie.movietrailerapp.util.MyMapKey
@Module
abstract class FakeViewModelModule {

    @Binds
    @IntoMap
    @MyMapKey(MockAllViewmodel::class)
    abstract fun listViewModel(allViewModel: MockAllViewmodel): ViewModel


    @Binds
    @IntoMap
    @MyMapKey(MockDetailViewModel::class)
    abstract fun detailViewModel(detailViewModel: MockDetailViewModel): ViewModel


}