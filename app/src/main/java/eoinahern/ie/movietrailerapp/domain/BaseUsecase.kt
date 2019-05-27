package eoinahern.ie.movietrailerapp.domain

import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers


abstract class BaseUsecase<T> {

    private val compositeDisposable = CompositeDisposable()
    private var IOScheduler = Schedulers.io()
    private var mainScheduler = AndroidSchedulers.mainThread()


    fun execute(
        observer: DisposableObserver<T>
    ) {
        compositeDisposable.add(
            buildObservable()
                .subscribeOn(IOScheduler)
                .observeOn(mainScheduler)
                .subscribeWith(observer)
        )
    }

    fun setSchedulers(main: Scheduler, io: Scheduler) {
        IOScheduler = io
        mainScheduler = main
    }

    abstract fun buildObservable(): Observable<T>

    fun clearDisposables() {
        compositeDisposable.clear()
    }
}