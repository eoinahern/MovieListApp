package eoinahern.ie.movietrailerapp.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import eoinahern.ie.movietrailerapp.ui.base.BaseActivity
import eoinahern.ie.movietrailerapp.ui.view.list.ListActivity
import eoinahern.ie.movietrailerapp.ui.view.all.AllSectionActivity
import eoinahern.ie.movietrailerapp.ui.view.detail.DetailActivity
import eoinahern.ie.movietrailerapp.ui.view.trailer.TrailerActivity


@Module
abstract class BuilderModule {

    @ContributesAndroidInjector
    abstract fun listInjector(): ListActivity

    @ContributesAndroidInjector
    abstract fun detailInjector(): DetailActivity

    @ContributesAndroidInjector
    abstract
    fun allInjector(): AllSectionActivity


    @ContributesAndroidInjector
    abstract fun baseInjector(): BaseActivity


    @ContributesAndroidInjector
    abstract fun trailerInjector(): TrailerActivity

}