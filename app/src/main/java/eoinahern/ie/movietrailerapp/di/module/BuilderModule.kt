package eoinahern.ie.movietrailerapp.di.module

import android.app.ListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import eoinahern.ie.movietrailerapp.ui.view.all.AllSectionActivity
import eoinahern.ie.movietrailerapp.ui.view.detail.DetailActivity


@Module
abstract class BuilderModule {

    @ContributesAndroidInjector
    abstract fun ListInjector(): ListActivity

    @ContributesAndroidInjector
    abstract fun detailInjector(): DetailActivity

    @ContributesAndroidInjector
    abstract fun AllInjector(): AllSectionActivity
}