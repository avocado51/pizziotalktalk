package com.avocado.pizziotalktalk.domain.chat;

import javax.validation.constraints.NotNull;

import java.math.BigInteger;

import javax.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "chatrooms")
public class Chatrooms {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private BigInteger id;

  @NotNull
  @Column(name = "name", length = 30)
  private String name;

  @Column(name = "password", length = 30)
  private String password;

}
