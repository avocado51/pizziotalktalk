package com.avocado.pizziotalktalk.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DuplicatedUsersException extends RuntimeException{
  public DuplicatedUsersException(String message) {
    super(message);
  }

}
