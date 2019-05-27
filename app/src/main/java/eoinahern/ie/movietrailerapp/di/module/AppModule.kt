package eoinahern.ie.movietrailerapp.di.module

import android.content.Context
import com.google.android.exoplayer2.ExoPlayerFactory
import dagger.Module
import dagger.Provides
import eoinahern.ie.movietrailerapp.MovieApp
import eoinahern.ie.movietrailerapp.data.api.RakutenAPI
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named
import javax.inject.Singleton


@Module
class AppModule {

    @Provides
    @Singleton
    fun getContext(app: MovieApp): Context {
        return app.applicationContext
    }


    @Provides
    @Singleton
    @Named("main")
    fun getMain(): Scheduler {
        return AndroidSchedulers.mainThread()
    }


    @Provides
    @Singleton
    @Named("io")
    fun getIO(): Scheduler {
        return Schedulers.io()
    }


    @Provides
    @Singleton
    fun getExoPlayer(context: Context) = ExoPlayerFactory.newSimpleInstance(context)
}