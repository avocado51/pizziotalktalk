package com.avocado.pizziotalktalk.controller.response;

import lombok.Data;

@Data
public class ResponseMessage {
	private boolean success;
	private Object response;
	private Object error;
}
