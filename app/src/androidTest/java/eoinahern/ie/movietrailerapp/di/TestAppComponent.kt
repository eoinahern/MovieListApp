package eoinahern.ie.movietrailerapp.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import eoinahern.ie.movietrailerapp.MovieAppTest
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class])
interface TestAppComponent {

    fun inject(application: MovieAppTest)

    @Component.Builder
    interface Builder {
        fun build(): TestAppComponent
        @BindsInstance
        fun application(app: MovieAppTest): Builder
    }
}