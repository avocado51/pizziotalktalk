package com.avocado.pizziotalktalk.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avocado.pizziotalktalk.controller.response.ResponseMessage;
import com.avocado.pizziotalktalk.domain.Users;
import com.avocado.pizziotalktalk.exception.NoUserIdException;
import com.avocado.pizziotalktalk.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/talks")
@RequiredArgsConstructor
public class TalkController {

	private final UserService userService;

	@GetMapping()
	public ResponseEntity<ResponseMessage> getTalksList(@RequestHeader("X-USER-ID") String userId) {
		Users user = userService.findUsers(userId);

		if (user == null) {
			throw new NoUserIdException("해당 아이디는 존재하지 않습니다.");
		}

		ResponseMessage responseMessage = new ResponseMessage();
		responseMessage.setSuccess(true);
		responseMessage.setResponse(user);

		ResponseEntity<ResponseMessage> response = new ResponseEntity(responseMessage, HttpStatus.OK);
		return response;
	}
}
