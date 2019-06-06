package eoinahern.ie.movietrailerapp.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import eoinahern.ie.movietrailerapp.MovieAppTest
import eoinahern.ie.movietrailerapp.di.module.FakeViewModelModule
import eoinahern.ie.movietrailerapp.di.module.InjectorModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, InjectorModule::class, FakeViewModelModule::class])
interface TestAppComponent {

    fun inject(application: MovieAppTest)

    @Component.Builder
    interface Builder {
        fun build(): TestAppComponent
        @BindsInstance
        fun application(app: MovieAppTest): Builder
    }
}