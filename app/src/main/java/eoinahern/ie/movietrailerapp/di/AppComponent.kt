package eoinahern.ie.movietrailerapp.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import eoinahern.ie.movietrailerapp.MovieApp
import eoinahern.ie.movietrailerapp.di.module.AppModule
import eoinahern.ie.movietrailerapp.di.module.BuilderModule
import eoinahern.ie.movietrailerapp.di.module.NetworkModule
import eoinahern.ie.movietrailerapp.di.module.ViewModelsModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ViewModelsModule::class, BuilderModule::class, AppModule::class, NetworkModule::class])
interface AppComponent {

    fun inject(application: MovieApp)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
        @BindsInstance
        fun application(app: MovieApp): Builder
    }
}