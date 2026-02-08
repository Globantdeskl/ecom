package com.aeo.framework.model.order;

import lombok.Data;

@Data
public class HeaderInstruction {
	
	private String instructionText;
	
    private String instructionType;
    
    private int lineNo;
    
    private String giftwrapMsgTo;
   	
    private String giftwrapMsgFrom;

}
