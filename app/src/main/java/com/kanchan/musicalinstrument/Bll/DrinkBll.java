package com.kanchan.musicalinstrument.Bll;

import com.kanchan.musicalinstrument.Api.DrinkApi;
import com.kanchan.musicalinstrument.Api.RetrofitCaller;
import com.kanchan.musicalinstrument.Model.Item;
import com.kanchan.musicalinstrument.Strictmodeclass.Strictmodeclass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DrinkBll {
    List<Item> itemList=  new ArrayList<>();
    Boolean status=false;
    DrinkApi drinksApi  = RetrofitCaller.getInstance().create(DrinkApi.class);

    public  List<Item> getAllItems() {
        Call<List<Item>> itemsCall = drinksApi.getAllItemsLIst();
        Strictmodeclass.StrictMode();
        try {
            itemList=  itemsCall.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return itemList;
    }

    public  Boolean insertItem(Item item){
        Call<Void> voidCall = drinksApi.insertItem(item);
        voidCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.isSuccessful()){
                    status=true;
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                status=false;
            }
        });
        return  status;
    }
}
