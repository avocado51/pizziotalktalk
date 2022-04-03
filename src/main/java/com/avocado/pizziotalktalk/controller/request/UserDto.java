package com.avocado.pizziotalktalk.controller.request;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

  @Size(min = 2, max = 30)
  private String nickName;

  @Size(min = 8, max = 100)
  private String password;

  @Size(min = 3, max = 50)
  private String name;

  @Size(max = 100)
  private String image;

  @Size(max = 30)
  private String email;

  @Size(min= 6, max = 8)
  private String birth;

}
