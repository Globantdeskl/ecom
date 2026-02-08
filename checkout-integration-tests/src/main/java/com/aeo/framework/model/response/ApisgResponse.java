package com.aeo.framework.model.response;

import lombok.Data;

@Data
public class ApisgResponse {
    private String access_token;
    private String token_type;
    private Integer expires_in;
    private String scope;
    private String JWT_TOKEN;

}
