package com.bookcatalogue.responses;

import javax.xml.bind.annotation.XmlRootElement;

import com.bookcatalogue.model.Book;

@XmlRootElement
public class BookNotFoundResponse extends Book{
	
	private String errorMessage;
	private int errorCode;
	private String successMessage;
	private String info;
	private String status;
	
	public BookNotFoundResponse() {}

	public BookNotFoundResponse(String errorMessage, int errorCode) {
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
		super.setId(-1);
	}	

	public BookNotFoundResponse(String successMessage, String info, String status) {
		this.successMessage = successMessage;
		this.info = info;
		this.status = status;
	}	

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

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
