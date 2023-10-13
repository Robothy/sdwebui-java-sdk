package io.github.robothy.sdwebui.sdk.models;

import lombok.Getter;

@Getter
public class SdWebuiOptions {

  private final String endpoint;

  public SdWebuiOptions(String endpoint) {
    this.endpoint = endpoint;
  }

}
