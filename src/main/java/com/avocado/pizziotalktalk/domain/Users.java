package com.avocado.pizziotalktalk.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
        {@UniqueConstraint(name = "unq_users_on_id_and_name",
        columnNames = {"id", "name"})})
public class Users extends TimeStamp {
  @NotNull
  @Column(name = "id", length = 50)
  private String id;

  @NotNull
  @Column(name = "name", length = 50)
  private String name;

  @NotNull
  @Column(name = "password", length = 61)
  private String password;
}
