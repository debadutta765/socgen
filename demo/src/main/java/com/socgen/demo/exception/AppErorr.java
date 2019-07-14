package com.socgen.demo.exception;

import java.io.Serializable;

public class AppErorr implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1172251742359989813L;
	private int errorCode;
	private String errorMessage;

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
