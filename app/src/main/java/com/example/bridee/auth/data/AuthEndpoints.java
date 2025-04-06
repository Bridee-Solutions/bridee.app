package com.example.bridee.auth.data;

import com.example.bridee.auth.domain.AuthenticationRequest;
import com.example.bridee.auth.domain.AuthenticationResponse;
import com.example.bridee.auth.domain.RegistrationState;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AuthEndpoints {

    @POST("casais")
    Call<Void> createCasal(@Body RegistrationState casalRequest);

    @GET("usuarios/{email}")
    Call<Void> validateEmail(@Path(value = "email") String email);

    @POST("authentication")
    Call<AuthenticationResponse> authenticate(@Body AuthenticationRequest request);
}