package eoinahern.ie.movietrailerapp.data.repository.detail

import eoinahern.ie.movietrailerapp.data.api.RakutenAPI
import javax.inject.Inject
import javax.inject.Singleton


/**
 *
 *used a factory if we want to add multiple data
 * sources
 */

@Singleton
class DetailDataSourceFactory @Inject constructor(private val api: RakutenAPI) {


    fun getDataSource(): DetailNetworkDataSource = DetailNetworkDataSource(api)
}