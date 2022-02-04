package com.avocado.pizziotalktalk.controller.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
	private Integer status;
	private String message;
}
