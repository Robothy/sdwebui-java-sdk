package io.github.robothy.sdwebui.sdk.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.robothy.sdwebui.sdk.exceptions.SdWebuiBadRequestException;
import io.github.robothy.sdwebui.sdk.exceptions.SdWebuiServerValidationException;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpStatus;

import java.io.IOException;

public class SdWebuiResponseUtils {

  public static void checkResponseStatus(ClassicHttpResponse response, ObjectMapper objectMapper) {
    if (response.getCode() == HttpStatus.SC_OK) {
      return;
    }

    try {
      if (response.getCode() == HttpStatus.SC_UNPROCESSABLE_ENTITY) {
        throw objectMapper.readValue(response.getEntity().getContent(), SdWebuiServerValidationException.class);
      }

      throw objectMapper.readValue(response.getEntity().getContent(), SdWebuiBadRequestException.class);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }

}
