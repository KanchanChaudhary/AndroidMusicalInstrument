package com.kanchan.musicalinstrument.Bll;

import com.kanchan.musicalinstrument.Api.BannerImageAPi;
import com.kanchan.musicalinstrument.Api.RetrofitCaller;
import com.kanchan.musicalinstrument.Model.BannerItem;
import com.kanchan.musicalinstrument.Strictmodeclass.Strictmodeclass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BannnerBll {
    List<BannerItem> lstBanners =  new ArrayList<>();
    BannerImageAPi bannerImageApi = RetrofitCaller.getInstance().create(BannerImageAPi.class);
    boolean status = false;

    public List<BannerItem> getAllBanners() {
        Strictmodeclass.StrictMode();
        Call<List<BannerItem>> apicaller = bannerImageApi.getAllBanners();
        try {
            lstBanners = apicaller.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lstBanners;

    }

    public boolean InsertBanner(BannerItem bannerItem) {
        Call<Void> bannerCaller = bannerImageApi.insertBanner(bannerItem);
        bannerCaller.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    status = true;
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                status = false;
            }
        });
        return status;
    }
}
