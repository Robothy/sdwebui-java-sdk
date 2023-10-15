package io.github.robothy.sdwebui.sdk.models.results;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class FaceRestorer {

  @JsonProperty("name")
  private String name;

  @JsonProperty("cmd_dir")
  private String cmdDir;

}
