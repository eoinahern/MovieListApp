package eoinahern.ie.movietrailerapp.di.module

import androidx.lifecycle.ViewModel
import eoinahern.ie.movietrailerapp.ui.view.detail.DetailViewModel
import eoinahern.ie.movietrailerapp.ui.view.list.ListViewModel
import eoinahern.ie.movietrailerapp.util.MyMapKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import eoinahern.ie.movietrailerapp.ui.view.trailer.TrailerViewModel


@Module
abstract class ViewModelsModule {

    @Binds
    @IntoMap
    @MyMapKey(ListViewModel::class)
    abstract fun listViewModel(listViewModel: ListViewModel): ViewModel


    @Binds
    @IntoMap
    @MyMapKey(DetailViewModel::class)
    abstract fun detailViewModel(detailViewModel: DetailViewModel): ViewModel
    

    @Binds
    @IntoMap
    @MyMapKey(TrailerViewModel::class)
    abstract fun trailerViewModel(allViewModel: TrailerViewModel): ViewModel
}