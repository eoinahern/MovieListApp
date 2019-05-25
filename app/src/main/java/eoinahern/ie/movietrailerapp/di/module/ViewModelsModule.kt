package eoinahern.ie.movietrailerapp.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import eoinahern.ie.movietrailerapp.ui.view.all.AllSectionViewModel
import eoinahern.ie.movietrailerapp.ui.view.detail.DetailViewModel
import eoinahern.ie.movietrailerapp.ui.view.list.ListViewModel
import eoinahern.ie.movietrailerapp.util.ViewModelKey


@Module
abstract class ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(ListViewModel::class)
    abstract fun listViewModel(listViewModel: ListViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    abstract fun detailViewModel(detailViewModel: DetailViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(AllSectionViewModel::class)
    abstract fun allViewModel(allViewModel: AllSectionViewModel): ViewModel
}