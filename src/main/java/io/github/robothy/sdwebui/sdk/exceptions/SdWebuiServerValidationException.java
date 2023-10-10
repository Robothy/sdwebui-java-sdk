package io.github.robothy.sdwebui.sdk.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SdWebuiServerValidationException extends SdWebuiServerException {

  @JsonProperty("detail")
  private Detail[] detail;

  public Detail[] getDetail() {
    return detail;
  }

  public void setDetail(Detail[] detail) {
    this.detail = detail;
  }

  @Data
  public static class Detail {

    @JsonProperty("loc")
    private String[] loc;

    @JsonProperty("msg")
    private String msg;

    @JsonProperty("type")
    private String type;

    public String[] getLoc() {
      return loc;
    }

    public void setLoc(String[] loc) {
      this.loc = loc;
    }

    public String getMsg() {
      return msg;
    }

    public void setMsg(String msg) {
      this.msg = msg;
    }

    public String getType() {
      return type;
    }

    public void setType(String type) {
      this.type = type;
    }
  }
}
