package eoinahern.ie.movietrailerapp.data.repository.list

import eoinahern.ie.movietrailerapp.data.api.RakutenAPI
import eoinahern.ie.movietrailerapp.data.model.MovieListEntry
import io.reactivex.Observable
import io.reactivex.rxkotlin.Observables


class ListNetworkDataSource constructor(private val api: RakutenAPI) : ListDataSource {

    override fun getList(list: List<String>): Observable<Map<String, List<MovieListEntry>>> {
        return Observables.zip(
            api.getList(list[0]), api.getList(list[1]),
            api.getList(list[2]), api.getList(list[3]),
            api.getList(list[4]), api.getList(list[5]),
            api.getList(list[6])
        ) { a, b, c, d, e, f, g ->

            val map = mutableMapOf<String, List<MovieListEntry>>(
                list[0] to a.data.contents, list[1] to b.data.contents, list[2] to c.data.contents,
                list[3] to d.data.contents, list[4] to e.data.contents, list[5] to f.data.contents,
                list[6] to g.data.contents
            ) as LinkedHashMap

            map
        }
    }
}