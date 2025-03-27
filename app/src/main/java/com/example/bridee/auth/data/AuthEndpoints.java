package com.example.bridee.auth.data;

import com.example.bridee.auth.presentation.registration.RegistrationState;

import okhttp3.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthEndpoints {

    @POST("/usuarios")
    Response createCasal(@Body RegistrationState casalRequest);
}