package com.teste.wa.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Patrick E. Estrela
 * @Data 21/09/20
 */
@Getter
@AllArgsConstructor
public class ErrorObject{

    private final String message;
    private final String field;
    private final Object parameter;
    
    
	public ErrorObject(String message, String field, Object parameter) {
		super();
		this.message = message;
		this.field = field;
		this.parameter = parameter;
	}


	public String getMessage() {
		return message;
	}


	public String getField() {
		return field;
	}


	public Object getParameter() {
		return parameter;
	}
}