package eoinahern.ie.movietrailerapp.data.repository.list

import eoinahern.ie.movietrailerapp.data.api.RakutenAPI
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class ListDataSourceFactory @Inject constructor(private val api: RakutenAPI) {

    private val listDataSource: ListDataSource

    init {
        listDataSource = ListNetworkDataSource(api)
    }

    fun getDataSource(): ListDataSource = listDataSource
}