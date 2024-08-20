package br.com.projeto.Portal360.rest.response;

public class MessageResponse {
	
	private String message;

	public MessageResponse(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
