package com.kanchan.musicalinstrument.Bll;

import com.kanchan.musicalinstrument.Api.UserApi;
import com.kanchan.musicalinstrument.ServerResponse.SignupResponse;
import com.kanchan.musicalinstrument.Url.url;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class LoginBll {
    Boolean isSuccess = false;

    public boolean checkUser(String username, String password){

        UserApi usersApi = url.getInstance().create(UserApi.class);
        Call<SignupResponse> usersCall = usersApi.CheckUser(username, password);

        try{
            Response<SignupResponse> loginResponse = usersCall.execute();
            if (loginResponse.isSuccessful() &&
                    loginResponse.body().getStatus().equals("Login success!")) {

                url.token += loginResponse.body().getToken();

                isSuccess = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
