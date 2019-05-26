package eoinahern.ie.movietrailerapp.domain

import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers


abstract class BaseUsecase<T> {

    private val compositeDisposable = CompositeDisposable()

    fun execute(
        observer: DisposableObserver<T>,
        mainScheduler: Scheduler = AndroidSchedulers.mainThread(),
        ioScheduler: Scheduler = Schedulers.io()
    ) {

        compositeDisposable.add(
            buildObservable().subscribeOn(ioScheduler)
                .observeOn(mainScheduler).subscribeWith(observer)
        )
    }

    abstract fun buildObservable(): Observable<T>

    fun clearDisposables() {
        compositeDisposable.clear()
    }
}