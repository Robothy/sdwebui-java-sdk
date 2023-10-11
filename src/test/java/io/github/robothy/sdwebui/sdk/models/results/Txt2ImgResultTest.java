package io.github.robothy.sdwebui.sdk.models.results;

import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.robothy.sdwebui.sdk.models.options.Txt2ImageOptions;
import java.util.List;
import org.junit.jupiter.api.Test;

class Txt2ImgResultTest {

  @Test
  void testSerialization() throws JsonProcessingException {
    Txt2ImgResult txt2ImgResult = new Txt2ImgResult();
    txt2ImgResult.setImages(List.of("image1", "image2"));
    txt2ImgResult.setInfo("info");
    txt2ImgResult.setParameters(Txt2ImageOptions.builder()
        .prompt("1dog")
        .build());

    ObjectMapper objectMapper = new ObjectMapper();
    assertEquals(txt2ImgResult, objectMapper.readValue(objectMapper
        .writeValueAsString(txt2ImgResult), Txt2ImgResult.class));
  }

}