package io.github.robothy.sdwebui.sdk.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class JsonUtils {

  private static final ObjectMapper objectMapper = new ObjectMapper();

  public static String toJson(Object object) {
    try {
      return objectMapper.writeValueAsString(object);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

  public static <T> T fromJson(String json, Class<T> clazz) {
    try {
      return objectMapper.readValue(json, clazz);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

  public static <T> T fromJson(InputStream inputStream, Class<T> clazz) {
    try {
      return objectMapper.readValue(inputStream, clazz);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
