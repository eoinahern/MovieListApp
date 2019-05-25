package eoinahern.ie.movietrailerapp.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import eoinahern.ie.movietrailerapp.MovieApp
import eoinahern.ie.movietrailerapp.di.module.AppModule
import eoinahern.ie.movietrailerapp.di.module.BuilderModule
import eoinahern.ie.movietrailerapp.di.module.NetworkModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class, BuilderModule::class, NetworkModule::class])
interface AppComponent {

    fun inject(app: MovieApp)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
        @BindsInstance
        fun application(app: MovieApp): Builder
    }
}