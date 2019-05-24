package eoinahern.ie.movietrailerapp.data

import eoinahern.ie.movietrailerapp.util.DEVICE_TYPE
import eoinahern.ie.movietrailerapp.util.ESP_COUNTRY_CODE
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


/**
 * hard code our locale and markey code here.
 * just for the sake of the test app.
 * otherwise we could inject them in our interceptor.
 *
 */


interface RakutenAPI {

    @GET("/v3/lists/{section}")
    fun getList(
        @Path("section") movieSection: String,
        @Query("classification_id") classification: Int = 6,
        @Query("device_identifier") deviceType: String = DEVICE_TYPE,
        @Query("locale") locale: String = ESP_COUNTRY_CODE,
        @Query("market_code") market_code: String = ESP_COUNTRY_CODE
    ): Observable<List<String>>


    @GET("/v3/movies/{movieName}")
    fun getMovie(
        @Path("movieName") movieName: String,
        @Query("classification_id") classification: Int = 6,
        @Query("device_identifier") deviceType: String = DEVICE_TYPE,
        @Query("locale") locale: String = ESP_COUNTRY_CODE,
        @Query("market_code") market_code: String = ESP_COUNTRY_CODE
    ): Observable<List<String>>


}