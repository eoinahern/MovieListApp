package eoinahern.ie.movietrailerapp.di.module

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import eoinahern.ie.movietrailerapp.data.api.ParamInterceptor
import eoinahern.ie.movietrailerapp.data.api.RakutenAPI
import eoinahern.ie.movietrailerapp.util.API_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
class NetworkModule {

    @Provides
    @Singleton
    fun getMoshi(): Moshi {
        return Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    }

    @Provides
    @Singleton
    fun interceptor(): ParamInterceptor {
        return ParamInterceptor()
    }

    @Provides
    @Singleton
    fun getApi(interceptor: ParamInterceptor, moshi: Moshi): RakutenAPI {

        return Retrofit.Builder()
            .baseUrl(API_URL)
            .client(OkHttpClient.Builder().addInterceptor(interceptor).build())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build().create(RakutenAPI::class.java)
    }

}