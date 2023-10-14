package io.github.robothy.sdwebui.sdk.models.results;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class SdModel {

  @JsonProperty("title")
  private String title;

  @JsonProperty("model_name")
  private String modelName;

  @JsonProperty("hash")
  private String hash;

  @JsonProperty("sha256")
  private String sha256;

  @JsonProperty("filename")
  private String filename;

  @JsonProperty("config")
  private String config;

}