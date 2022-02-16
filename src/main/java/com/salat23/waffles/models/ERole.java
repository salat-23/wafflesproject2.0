package com.salat23.waffles.models;

import lombok.Data;

public enum ERole {


  ROLE_USER(0),
  ROLE_MEMBER(1),
  ROLE_MODERATOR(2),
  ROLE_ADMIN(3);

  public int getPriority() {
    return priority;
  }

  private final int priority;

  ERole(int priority) {

    this.priority = priority;

  }


}
