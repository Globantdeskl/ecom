package com.aeo.framework.model.ghostRetail.returnSummary;

import com.aeo.framework.model.ghostRetail.BaseMessage;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ReturnSummaryMessage extends BaseMessage {

    @JsonProperty("ReturnSummary")
    private ReturnSummary returnSummary;
}
