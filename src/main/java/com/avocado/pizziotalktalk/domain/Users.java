package com.avocado.pizziotalktalk.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Users extends TimeStamp {
	@Id
	@Column(name = "id", length = 50)
	private String id;

  @NotNull
  @Column(name = "password", length = 50)
  private String password;
}
