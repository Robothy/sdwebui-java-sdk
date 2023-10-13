package io.github.robothy.sdwebui.sdk.utils;

import io.github.robothy.sdwebui.sdk.exceptions.SdWebuiBadRequestException;
import io.github.robothy.sdwebui.sdk.exceptions.SdWebuiServerValidationException;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpStatus;

public class SdWebuiResponseUtils {

  public static void checkResponseStatus(ClassicHttpResponse response) {
    if (response.getCode() == HttpStatus.SC_OK) {
      return;
    }

    try {
      if (response.getCode() == HttpStatus.SC_UNPROCESSABLE_ENTITY) {
        JsonUtils.fromJson(response.getEntity().getContent(), SdWebuiServerValidationException.class);
      }

      throw JsonUtils.fromJson(response.getEntity().getContent(), SdWebuiBadRequestException.class);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }

  public static <T> T parseResponse(ClassicHttpResponse response, Class<T> clazz) {
    checkResponseStatus(response);
    try {
      return JsonUtils.fromJson(response.getEntity().getContent(), clazz);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}
