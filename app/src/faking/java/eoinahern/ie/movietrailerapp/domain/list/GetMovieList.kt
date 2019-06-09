package eoinahern.ie.movietrailerapp.domain.list

import eoinahern.ie.movietrailerapp.data.model.HighlightedScore
import eoinahern.ie.movietrailerapp.data.model.MovieClassification
import eoinahern.ie.movietrailerapp.data.model.MovieImages
import eoinahern.ie.movietrailerapp.data.model.MovieListEntry
import eoinahern.ie.movietrailerapp.domain.BaseUsecase
import io.reactivex.Observable
import javax.inject.Inject

class GetMovieList @Inject constructor() : BaseUsecase<Map<String, List<MovieListEntry>>>() {


    fun setList(listIn: List<String>) {
        //no need to implement anything here
    }

    override fun buildObservable(): Observable<Map<String, List<MovieListEntry>>> {
        return Observable.just(
            mapOf(
                "test list!!" to listOf(
                    MovieListEntry(
                        "movie",
                        "avatar",
                        666,
                        "lovely movie",
                        1999,
                        300,
                        "label",
                        MovieClassification("12", "movie", "movie", 12, true, "a great story"),
                        MovieImages(
                            "https://images-3.wuaki.tv/system/artworks/98484/master/feliz-dia-de-tu-muerte-2-1558522756.jpeg",
                            "\"https://images-3.wuaki.tv/system/artworks/98484/master/feliz-dia-de-tu-muerte-2-1558522756.jpeg"
                        ),
                        HighlightedScore(6f, 2000, "2K"),
                        mapOf("top" to 8, "bbc" to 4)
                    )
                )
            )
        )
    }

}