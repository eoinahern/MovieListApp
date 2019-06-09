package eoinahern.ie.movietrailerapp.domain.detail

import eoinahern.ie.movietrailerapp.domain.BaseUsecase
import eoinahern.ie.movietrailerapp.data.model.MovieImages
import eoinahern.ie.movietrailerapp.data.model.NestedSingleMovieData
import io.reactivex.Observable
import javax.inject.Inject

class GetMovieDetailUsecase @Inject constructor() : BaseUsecase<NestedSingleMovieData>() {

    fun setId(str: String) {
    }

    override fun buildObservable(): Observable<NestedSingleMovieData> {
        return Observable.just(
            NestedSingleMovieData(
                "", "", 1, "avatar",
                "avatar", 2000, "plot. a movie. very enjoyable. huzzah",
                "plot. awesome movie about stuff. hooray", 60, 3600, listOf(),
                MovieImages(
                    "https://images-3.wuaki.tv/system/artworks/98484/master/feliz-dia-de-tu-muerte-2-1558522756.jpeg",
                    "https://images-3.wuaki.tv/system/artworks/98484/master/feliz-dia-de-tu-muerte-2-1558522756.jpeg"
                ), listOf(), listOf()
            )
        )
    }


}