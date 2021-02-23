package com.kanchan.musicalinstrument.Api;

import com.kanchan.musicalinstrument.Model.BannerItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface BannerImageAPi {
    @POST("banner/create")
    Call<Void> insertBanner(@Body BannerItem bannerItem);

    @GET("banner/all")
    Call<List<BannerItem>> getAllBanners();
}
