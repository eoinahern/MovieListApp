package eoinahern.ie.movietrailerapp.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import eoinahern.ie.movietrailerapp.MovieApp
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class])
interface AppComponent {

    fun inject(app: MovieApp)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
        @BindsInstance
        fun application(app: MovieApp): Builder
    }
}