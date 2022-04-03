package com.avocado.pizziotalktalk.domain;

import java.math.BigInteger;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.avocado.pizziotalktalk.domain.enums.UserConnectStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users", uniqueConstraints =
        {@UniqueConstraint(name = "unq_users_on_email_and_nick_name",
        columnNames = {"email", "nick_name"})})
public class Users extends TimeStamp {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private BigInteger id;

  @NotNull
  @Column(name = "nick_name", length = 30)
  private String nickName;

  @NotNull
  @Column(name = "password", length = 100)
  private String password;

  // token은 저장하지 않는 방향으로 간다. - cache에 저장
  @Column(name = "token", length = 100)
  private String token;

  @NotNull
  @Column(name = "name", length = 50)
  private String name;

  @Column(name = "image", length = 100)
  private String image;

  @NotNull
  @Column(name = "email", length = 30)
  private String email;

  @Column(name = "birth", length = 20)
  private String birth;

  @NotNull
  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private UserConnectStatus status;

}
