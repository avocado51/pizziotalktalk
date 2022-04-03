package com.avocado.pizziotalktalk.domain.chat;

import java.math.BigInteger;

import javax.persistence.*;
import lombok.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "chatroom_users")
public class ChatroomUsers {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private BigInteger id;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "users_id")
  private BigInteger userId;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "chatrooms_id")
  private BigInteger chatroomId;

}
