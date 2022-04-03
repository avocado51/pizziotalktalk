package com.avocado.pizziotalktalk.domain.chat;

import com.avocado.pizziotalktalk.domain.TimeStamp;
import com.avocado.pizziotalktalk.domain.Users;

import javax.validation.constraints.NotNull;

import java.math.BigInteger;

import javax.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "chats")
public class Chats extends TimeStamp {
	// kafka framework을 사용하면 채팅 메시지 정보는 db에 저장하지 않는다.

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private BigInteger id;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "users_id")
  private Users userId;

  @NotNull
  @Column(name = "message", length = 100)
  private String message;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "chatrooms_id")
  private BigInteger chatroomId;

}
