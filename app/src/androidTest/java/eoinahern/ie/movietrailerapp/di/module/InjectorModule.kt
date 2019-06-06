package eoinahern.ie.movietrailerapp.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import eoinahern.ie.movietrailerapp.ui.view.all.AllSectionActivity
import eoinahern.ie.movietrailerapp.ui.view.detail.DetailActivity


@Module
abstract class InjectorModule {

    @ContributesAndroidInjector
    abstract fun allActivity() : AllSectionActivity

    @ContributesAndroidInjector
    abstract fun detailsActivity() : DetailActivity

}