package com.aeo.framework.controllers;

import com.aeo.framework.Environment;
import com.aeo.framework.clients.FraudCheckClient;
import com.aeo.framework.clients.TaxCalculatorClient;
import com.aeo.framework.decoders.ClientErrorDecoder;
import com.aeo.framework.decoders.CustomDecoder;
import feign.Client;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonEncoder;
import feign.slf4j.Slf4jLogger;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CheckoutControllers extends BaseController {

    @Autowired
    Environment environment;

    public TaxCalculatorClient taxCalculatorClient(){

        return Feign.builder().
                client(new Client.Default(getSSLSocketFactory(), new NoopHostnameVerifier()))
                .encoder(new GsonEncoder())
                .decoder(new CustomDecoder())
                .errorDecoder(new ClientErrorDecoder())
                .logger(new Slf4jLogger(TaxCalculatorClient.class))
                .logLevel(Logger.Level.FULL)
                .target(TaxCalculatorClient.class, environment.checkoutTaxCalculator);
    }

    public FraudCheckClient fraudCheckClient(){
        return Feign.builder().
                client(new Client.Default(getSSLSocketFactory(), new NoopHostnameVerifier()))
                .encoder(new GsonEncoder())
                .decoder(new CustomDecoder())
                .errorDecoder(new ClientErrorDecoder())
                .logger(new Slf4jLogger(FraudCheckClient.class))
                .logLevel(Logger.Level.FULL)
                .target(FraudCheckClient.class, environment.checkoutFraudCheck);
    }

}
