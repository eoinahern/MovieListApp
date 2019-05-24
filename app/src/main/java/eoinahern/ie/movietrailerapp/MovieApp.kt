package eoinahern.ie.movietrailerapp

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.HasActivityInjector


class MovieApp : Application(), HasActivityInjector {





    override fun activityInjector(): AndroidInjector<Activity> {

    }

    override fun onCreate() {
        super.onCreate()
    }


}