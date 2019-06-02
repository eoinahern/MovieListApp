package eoinahern.ie.movietrailerapp.data.api

import eoinahern.ie.movietrailerapp.data.model.MovieGroupingWrapper
import eoinahern.ie.movietrailerapp.data.model.SingleMovieItem
import eoinahern.ie.movietrailerapp.data.model.StreamBody
import eoinahern.ie.movietrailerapp.data.model.WrappedMovieTrailerData
import eoinahern.ie.movietrailerapp.util.DEVICE_TYPE
import eoinahern.ie.movietrailerapp.util.ESP_COUNTRY_CODE
import io.reactivex.Observable
import retrofit2.http.*


/**
 * hard code our locale and market code here.
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
    ): Observable<SingleMovieItem>


    /**
     * could use constants here.
     * initially set a POST body item.
     * this did not work. so, used params.
     * also could of swapped out seperate interceptor.
     *
     */

    @POST("/v3/me/streamings")
    fun streamMovie(
        @Query("content_id") movie_id: String,
        @Query("device_stream_video_quality") quality: String = "SD",
        @Query("audio_quality") audio: String = "2.0",
        @Query("audio_language") language: String = "SPA",
        @Query("subtitle_language") subtitle: String = "MIS",
        @Query("video_type") vid: String = "trailer",
        @Query("player") player: String = "android:PD-NONE",
        @Query("content_type") content: String = "movies",
        @Query("device_serial") serial: String = "device_serial_1"

    ): Observable<WrappedMovieTrailerData>

}