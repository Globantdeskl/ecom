package com.aeo.framework.controllers;

import com.aeo.framework.clients.ApisgClient;
import com.aeo.framework.decoders.ClientErrorDecoder;
import com.aeo.framework.decoders.CustomDecoder;
import feign.Client;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonEncoder;
import feign.slf4j.Slf4jLogger;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApisgController extends BaseController{

    @Value("${apisg.endpoint}")
    private String apisgEndpoint;

    public ApisgClient apisgClient(){

        return Feign.builder().
                client(new Client.Default(getSSLSocketFactory(), new NoopHostnameVerifier()))
                .encoder(new GsonEncoder())
                .decoder(new CustomDecoder())
                .errorDecoder(new ClientErrorDecoder())
                .logger(new Slf4jLogger(ApisgClient.class))
                .logLevel(Logger.Level.FULL)
                .target(ApisgClient.class, apisgEndpoint);
    }
}
