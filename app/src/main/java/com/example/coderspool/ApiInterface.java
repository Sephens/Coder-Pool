package com.example.coderspool;


import Model.Headlines;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

   @GET("/v2/top-headlines")
    Call<Headlines> getHeadlines(
           @Query("country") String country,
           @Query("apiKey") String apiKey
   );

}
