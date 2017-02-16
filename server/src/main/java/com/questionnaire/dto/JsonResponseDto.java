package com.questionnaire.dto;

public class JsonResponseDto {
	private int status;
	private String message;
	private Object data;
	
	public JsonResponseDto() {
	
	}
	
	public JsonResponseDto(int status, String message, Object data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public static enum Status {

		SUCCESS(1), FAILURE(0);
		Status(int s) {
			status = s;
		}

		private int status;

		public int getStatus() {
			return status;
		}
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String msg) {
		this.message = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}


	@Override
	public String toString() {
		return "JsonResponseDto [status=" + status + ", message=" + message + ", data=" + data 
				+ "]";
	}

}
