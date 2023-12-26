package com.aeo.framework.model.ghostRetail;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BaseMessage {

    @JsonProperty("MessageType")
    protected String messageType;
}
