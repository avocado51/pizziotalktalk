package com.avocado.pizziotalktalk.controller;

import com.avocado.pizziotalktalk.controller.response.ResponseMessage;

import java.time.LocalDateTime;

import com.avocado.pizziotalktalk.controller.request.UserDto;
import com.avocado.pizziotalktalk.domain.Users;
import com.avocado.pizziotalktalk.exception.NoUserIdException;
import com.avocado.pizziotalktalk.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping("/signUp")
  public ResponseEntity<ResponseMessage> signUp(@RequestHeader("X-USER-ID") String userId, @RequestBody UserDto userDto) {
    Users user = new Users();

    user.setId(userId);
    user.setCreatedAt(LocalDateTime.now());

    Users savedUsers = userService.createUsers(user);

    ResponseMessage responseMessage = new ResponseMessage();
    responseMessage.setSuccess(true);
    responseMessage.setResponse(savedUsers);

    ResponseEntity<ResponseMessage> response = new ResponseEntity(responseMessage, HttpStatus.CREATED);

    return response;
  }

  @PostMapping("/signIn")
  public ResponseEntity<ResponseMessage> signIn(@RequestHeader("X-USER-ID") String userId, @RequestBody UserDto userDto) {
    Users user = userService.findUsers(userId);

    if (user == null) {
      throw new NoUserIdException("해당 아이디는 존재하지 않습니다.");
    }

    if (!userService.checkPassword(userDto.getPassword(), user)) {
      throw new NoUserIdException("해당 아이디는 존재하지 않습니다.");
    }

    ResponseMessage responseMessage = new ResponseMessage();
    responseMessage.setSuccess(true);
    responseMessage.setResponse(user);

    ResponseEntity<ResponseMessage> response = new ResponseEntity(responseMessage, HttpStatus.OK);

    return response;
  }
}
