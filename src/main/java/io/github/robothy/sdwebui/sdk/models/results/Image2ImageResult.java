package io.github.robothy.sdwebui.sdk.models.results;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.robothy.sdwebui.sdk.models.options.Image2ImageOptions;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Image2ImageResult {

  @JsonProperty("images")
  private List<String> images;

  @JsonProperty("parameters")
  private Image2ImageOptions parameters;

  @JsonProperty("info")
  private String info;

}
