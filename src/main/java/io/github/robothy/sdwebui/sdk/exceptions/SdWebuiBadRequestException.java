package io.github.robothy.sdwebui.sdk.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SdWebuiBadRequestException extends SdWebuiServerException {
  @JsonProperty("error")
  private String error;

  @JsonProperty("detail")
  private String detail;

  @JsonProperty("body")
  private String body;

  @JsonProperty("errors")
  private String errors;

  // getters and setters
}
