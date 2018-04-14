package com.bookcatalogue.responses;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CreateBookResponse {

	private String successMessage;
	private String uri;	
	
	public CreateBookResponse() {}
	
	public CreateBookResponse(String successMessage, String uri) {
		this.successMessage = successMessage;
		this.uri = uri;
	}
	public String getSuccessMessage() {
		return successMessage;
	}
	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	
	
}
