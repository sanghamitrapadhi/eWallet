package com.wallet.message;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseMessage {
	
	private String value;
	private String message;
	
}
