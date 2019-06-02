package eoinahern.ie.movietrailerapp.data.repository.trailer

import com.google.android.exoplayer2.source.ProgressiveMediaSource
import eoinahern.ie.movietrailerapp.domain.repository.TrailerRepo
import io.reactivex.Observable
import javax.inject.Inject


class TrailerRepoImp @Inject constructor() : TrailerRepo<ProgressiveMediaSource> {


    override fun getTrailerSource(id: String): Observable<ProgressiveMediaSource> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}