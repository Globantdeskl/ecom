package com.aeo.framework.decoders;

import feign.FeignException;
import feign.codec.ErrorDecoder;
import org.testng.TestException;


import static feign.FeignException.errorStatus;

public class ClientErrorDecoder implements ErrorDecoder {

    //TODO: this is just an example, need to refactor and add more meaningful logs
    @Override
    public Exception decode(String methodKey, feign.Response response) {
        FeignException exception = errorStatus(methodKey, response);

        if (response.status() >= 400 && response.status() <= 499) {
            return new TestException(
                    exception.getMessage(),
                    exception.getCause()
            );
        }
        if (response.status() >= 500 && response.status() <= 599) {
            return new TestException(
                    exception.getMessage(),
                    exception.getCause()
            );
        }
        return errorStatus(methodKey, response);    }
}