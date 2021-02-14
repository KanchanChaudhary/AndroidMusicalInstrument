package com.kanchan.musicalinstrument.Api;

import com.kanchan.musicalinstrument.Model.Item;
import com.kanchan.musicalinstrument.ServerResponse.ImageResponse;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface DrinkApi {
    @GET("harddrink/all")
    Call<List<Item>> getAllItemsLIst();

    @Multipart
    @POST("uploads")
    Call<ImageResponse> uploadImage(@Part MultipartBody.Part img);

    @POST("harddrink/harddrink")
    Call<Void> insertItem(@Body Item item);
}
