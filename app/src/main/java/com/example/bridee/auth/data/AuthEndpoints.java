package com.example.bridee.auth.data;

import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthEndpoints {

    @POST("/usuarios")
    void createCasal(@Body CasalRequest casalRequest);
}