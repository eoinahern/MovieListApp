package eoinahern.ie.movietrailerapp

import android.app.Activity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import eoinahern.ie.movietrailerapp.di.DaggerTestAppComponent
import javax.inject.Inject

class MovieAppTest : MovieApp() {

    @Inject
    override lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        DaggerTestAppComponent.builder().application(this).build().inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }


}