package io.github.robothy.sdwebui.sdk.models.results;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.robothy.sdwebui.sdk.models.options.Image2ImageOptions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Image2ImageResultTest {

  @Test
  void testSerialization() {
    Image2ImageResult result = new Image2ImageResult();
    result.setImages(List.of("image1", "image2"));
    result.setParameters(Image2ImageOptions.builder()
      .prompt("prompt")
      .build());
    result.setInfo("info");

    ObjectMapper objectMapper = new ObjectMapper();
    assertEquals(result, objectMapper.convertValue(objectMapper.convertValue(result, Object.class), Image2ImageResult.class));
  }

}