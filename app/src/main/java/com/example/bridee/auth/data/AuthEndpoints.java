package com.example.bridee.auth.data;

import com.example.bridee.auth.domain.RegistrationState;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthEndpoints {

    @POST("casais")
    Call<Void> createCasal(@Body RegistrationState casalRequest);
}