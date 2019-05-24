package eoinahern.ie.movietrailerapp.di

import dagger.BindsInstance
import dagger.Component
import eoinahern.ie.movietrailerapp.MovieApp


@Component(modules = [AppModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: MovieApp): Builder

        fun build(): AppComponent
    }
}