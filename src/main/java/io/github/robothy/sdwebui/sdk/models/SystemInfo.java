package io.github.robothy.sdwebui.sdk.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SystemInfo {

  @JsonProperty("Platform")
  private String platform;

  @JsonProperty("Python")
  private String pythonVersion;

  @JsonProperty("Version")
  private String sdwebuiVersion;

}
