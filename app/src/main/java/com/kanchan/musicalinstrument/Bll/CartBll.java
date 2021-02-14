package com.kanchan.musicalinstrument.Bll;

import com.kanchan.musicalinstrument.Api.UserApi;
import com.kanchan.musicalinstrument.Model.Cart;
import com.kanchan.musicalinstrument.Url.url;


import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class CartBll {
    boolean isSuccess = false;

    public boolean checkcart(String userId, String itemID) {
        UserApi usersAPI = url.getInstance().create(UserApi.class);
        Call<Cart> addCart = usersAPI.addcart(url.token,itemID);
        try {
            Response<Cart> response = addCart.execute();
            if(response.code()==200)
            {
                isSuccess = true;
            }else {
                isSuccess = false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
