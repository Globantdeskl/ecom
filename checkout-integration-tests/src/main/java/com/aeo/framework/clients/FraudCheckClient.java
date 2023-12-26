package com.aeo.framework.clients;

import com.aeo.framework.model.response.FraudResponse;
import com.aeo.framework.model.response.TaxResponseBody;
import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface FraudCheckClient {

    @RequestLine("POST /fraud/check")
    @Headers("Content-Type: application/json")
    @Body("{body}")
    FraudResponse check(@Param("body") String body);

}
