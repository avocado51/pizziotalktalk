package com.avocado.pizziotalktalk.controller.request;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
  @Size(min = 2, max = 50)
  private String nickName;

  @Size(min = 8, max = 50)
  private String password;
}
