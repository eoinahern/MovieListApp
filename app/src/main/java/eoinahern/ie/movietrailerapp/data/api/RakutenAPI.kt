package eoinahern.ie.movietrailerapp.data.api

import eoinahern.ie.movietrailerapp.data.model.MovieGroupingWrapper
import eoinahern.ie.movietrailerapp.util.DEVICE_TYPE
import eoinahern.ie.movietrailerapp.util.ESP_COUNTRY_CODE
import io.reactivex.Observable
import retrofit2.http.*


/**
 * hard code our locale and markey code here.
 * just for the sake of the test app.
 * otherwise we could inject them in our interceptor.
 *
 */


interface RakutenAPI {

    @GET("/v3/lists/{section}")
    fun getList(
        @Path("section") movieSection: String
    ): Observable<MovieGroupingWrapper>


    @GET("/v3/movies/{movieName}")
    fun getMovie(
        @Path("movieName") movieName: String
    ): Observable<List<String>>


    @POST("/v3/me/streamings")
    fun streamMovie(@Body item: String): Observable<String>


}