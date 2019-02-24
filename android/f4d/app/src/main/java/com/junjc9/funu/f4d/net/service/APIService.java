package com.junjc9.funu.f4d.net.service;

import com.junjc9.funu.f4d.F4dInit;
import com.junjc9.funu.f4d.data.res.GankRes;

import io.reactivex.Flowable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;




public class APIService {
    private static String BASE_URL = "https://blog.funu.junjc9.com";

    public APIs apis;

    private static APIService instance;

    public static APIService getInstance() {
        if (instance == null) {
            instance = new APIService();
        }
        return instance;
    }

    private APIService() {
        Retrofit storeRestAPI = new Retrofit.Builder().baseUrl(BASE_URL)
                .client(F4dInit.mOkHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apis = storeRestAPI.create(APIs.class);
    }

    public interface APIs{

        /* Gank.io 妹子图 */
        @GET("http://gank.io/api/data/福利/{count}/{page}")
        Flowable<GankRes> fetchGankIO(
                @Path("count") int count,
                @Path("page") int page
        );

    }
}
