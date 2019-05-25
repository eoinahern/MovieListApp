package eoinahern.ie.movietrailerapp.di

import android.content.Context
import dagger.Module
import dagger.Provides
import eoinahern.ie.movietrailerapp.MovieApp
import javax.inject.Singleton


@Module
class AppModule {

    @Provides
    @Singleton
    fun getContext(app: MovieApp): Context {
        return app.applicationContext
    }
}