package com.netfilms.NetFilms.error;

import lombok.Getter;

@Getter
public class ErrorMessage {
  private final String msg;

  public ErrorMessage(String msg) {
    this.msg = msg;
  }
}
