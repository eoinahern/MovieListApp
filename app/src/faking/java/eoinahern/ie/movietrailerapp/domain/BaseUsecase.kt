package eoinahern.ie.movietrailerapp.domain

import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers


abstract class BaseUsecase<T> {

    private val composite = CompositeDisposable()

    private val ioScheduler: Scheduler = Schedulers.trampoline()
    private val mainScheduler: Scheduler = Schedulers.trampoline()

    fun execute(dipObserver: DisposableObserver<T>) {

        composite.add(
            buildObservable()
                .subscribeOn(ioScheduler)
                .observeOn(mainScheduler)
                .subscribeWith(dipObserver)
        )
    }

    abstract fun buildObservable(): Observable<T>

    fun clearDisposables() {
        composite.clear()
    }
}