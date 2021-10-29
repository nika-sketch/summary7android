package ge.nlatsabidze.summary7.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiInstance {

    val ApiClient by lazy {
        Retrofit.Builder()
            .baseUrl("https://reqres.in/api/")
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder().addLast(
                        KotlinJsonAdapterFactory()
                    ).build()))
            .build()
            .create(Api::class.java)
    }
}