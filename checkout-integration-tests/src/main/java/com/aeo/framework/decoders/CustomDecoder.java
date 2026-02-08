package com.aeo.framework.decoders;


import com.google.gson.Gson;
import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

public class CustomDecoder implements Decoder {

    @Override
    public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {

        Gson g = new Gson();
        Object p = g.fromJson(response.body().asReader(StandardCharsets.UTF_8), type);

        return p;
    }
}
