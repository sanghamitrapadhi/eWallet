package com.wallet.message;
/**
 * @author Sanghamitra
 * Model object for Response object
 */
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseMessage {
	
	private String value;
	private String message;
	
}
