package eoinahern.ie.movietrailerapp.data.repository.trailer

import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import eoinahern.ie.movietrailerapp.data.api.RakutenAPI
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class TrailerDataSourceFactory @Inject constructor(
    val api: RakutenAPI,
    val defaultDataSource: DefaultDataSourceFactory
) {


    fun getDataSource(): TrailerDataSource {
        return TrailerNetworkDataSource(api, defaultDataSource)
    }


}