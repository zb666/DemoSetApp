package com.example.mechrevo.demosetapp.douban;



import retrofit2.Call;
import retrofit2.http.GET;

public interface IDouBanApi {

    @GET("v2/movie/top250?start=10&count=10")
    Call<DouBanBean> getDouBanApi();

}
