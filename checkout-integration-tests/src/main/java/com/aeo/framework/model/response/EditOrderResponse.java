package com.aeo.framework.model.response;

import com.aeo.framework.model.ErrorObj;
import lombok.Data;

import java.util.List;

@Data
public class EditOrderResponse {
    boolean status;
    String reason;
    List<ErrorObj> errors;

    public boolean getStatus() {
        return status;
    }
}
