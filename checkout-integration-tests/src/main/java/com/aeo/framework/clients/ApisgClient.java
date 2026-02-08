package com.aeo.framework.clients;

import com.aeo.framework.model.response.ApisgResponse;
import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface ApisgClient {

    @RequestLine("POST /auth/oauth/v2/token")
    @Headers({
            "Content-Type: application/x-www-form-urlencoded",
            "Authorization: {token}",
            "Content-Length: 0"})
    @Body("grant_type=client_credentials")
    ApisgResponse getAccessToken(@Param("token") String token);

    @RequestLine("GET /jwttoken?email={email}")
    @Headers({"x-access-token: {accessToken}"})
    ApisgResponse getJWToken(@Param("accessToken") String accessToken,
                             @Param("email") String email);
}
