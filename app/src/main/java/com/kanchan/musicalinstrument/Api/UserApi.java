package com.kanchan.musicalinstrument.Api;

import com.kanchan.musicalinstrument.Model.Cart;
import com.kanchan.musicalinstrument.Model.User;
import com.kanchan.musicalinstrument.ServerResponse.CartResponse;
import com.kanchan.musicalinstrument.ServerResponse.ImageResponse;
import com.kanchan.musicalinstrument.ServerResponse.SignupResponse;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface UserApi {
    @POST("/users/signup")
    Call<SignupResponse> registerUser(@Body User user);

    @FormUrlEncoded
    @POST("users/login")
    Call<SignupResponse> CheckUser(@Field("username") String username, @Field("password") String password);

    @FormUrlEncoded
    @POST("cart/checkcart")
    Call<CartResponse> checkcart(@Field("productid") String productid, @Field("userid") String userid);

    @POST("cart/addcart")
    Call<Void> addcart(@Body Cart cart);

    @Multipart
    @POST("upload")
    Call<ImageResponse> uploadImage(@Part MultipartBody.Part img);

    @GET("users/me")
    Call<User> getUserDetails(@Header("Authorization") String token);
}

