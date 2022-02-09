package com.avocado.pizziotalktalk.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import lombok.Data;

@MappedSuperclass
@Data
public abstract class TimeStamp {
  @NotNull
  @Column(name = "created_at")
  LocalDateTime createdAt;

  @Column(name = "update_at")
  LocalDateTime updatedAt;
}
