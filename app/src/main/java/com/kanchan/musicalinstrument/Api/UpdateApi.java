package com.kanchan.musicalinstrument.Api;

import com.kanchan.musicalinstrument.Model.Update;
import com.kanchan.musicalinstrument.Model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UpdateApi {
    @GET("update/all")
    Call<List<User>> getUserDetails();

    @POST("update/create")
    Call<Void> insertuser(@Body Update update);
}
