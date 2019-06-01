package eoinahern.ie.movietrailerapp.data.repository.detail

import eoinahern.ie.movietrailerapp.data.api.RakutenAPI
import eoinahern.ie.movietrailerapp.data.model.MovieListEntry
import eoinahern.ie.movietrailerapp.data.model.NestedSingleMovieData
import io.reactivex.Observable


class DetailNetworkDataSource(val api: RakutenAPI) : DetailsDataSource {
    override fun getDetailItem(id: String): Observable<NestedSingleMovieData> =
        api.getMovie(id).map { it.nestedData }
}