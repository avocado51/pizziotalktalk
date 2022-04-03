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
@Table(name = "chat_unread_user")
public class ChatUnreadUser {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private BigInteger id;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "users_id")
  private BigInteger userId;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "chats_id")
  private BigInteger chatId;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "chatrooms_id")
  private BigInteger chatroomId;

}
