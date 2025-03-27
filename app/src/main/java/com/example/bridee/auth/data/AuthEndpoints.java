package com.example.bridee.auth.data;

import com.example.bridee.auth.presentation.registration.RegistrationState;

import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthEndpoints {

    @POST("/usuarios")
    void createCasal(@Body RegistrationState casalRequest);
}