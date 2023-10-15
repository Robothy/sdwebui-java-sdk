package io.github.robothy.sdwebui.sdk.models.results;

import io.github.robothy.sdwebui.sdk.utils.JsonUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FaceRestorerTest {

  @Test
  void testSerialization() {
    String faceRestorersJson = "[\n" +
      "  {\n" +
      "    \"name\": \"CodeFormer\",\n" +
      "    \"cmd_dir\": \"C:\\\\Users\\\\admin\\\\PythonProjects\\\\stable-diffusion-webui\\\\models\\\\Codeformer\"\n" +
      "  },\n" +
      "  {\n" +
      "    \"name\": \"GFPGAN\",\n" +
      "    \"cmd_dir\": null\n" +
      "  }\n" +
      "]";

    FaceRestorer[] faceRestorers = JsonUtils.fromJson(faceRestorersJson, FaceRestorer[].class);
    assertEquals(2, faceRestorers.length);
    assertEquals("CodeFormer", faceRestorers[0].getName());
    assertEquals("C:\\Users\\admin\\PythonProjects\\stable-diffusion-webui\\models\\Codeformer", faceRestorers[0].getCmdDir());
    assertEquals("GFPGAN", faceRestorers[1].getName());
    assertNull(faceRestorers[1].getCmdDir());
  }

}