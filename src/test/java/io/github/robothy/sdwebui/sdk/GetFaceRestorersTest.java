package io.github.robothy.sdwebui.sdk;

import io.github.robothy.sdwebui.sdk.models.results.FaceRestorer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockserver.client.MockServerClient;
import org.mockserver.junit.jupiter.MockServerExtension;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockServerExtension.class)
class GetFaceRestorersTest {

  @Test
  void getFaceRestorers(MockServerClient client) {
    client.when(new HttpRequest().withMethod("GET").withPath("/sdapi/v1/face-restorers"))
      .respond(new HttpResponse().withStatusCode(200).withBody("[\n" +
        "  {\n" +
        "    \"name\": \"CodeFormer\",\n" +
        "    \"cmd_dir\": \"C:\\\\Users\\\\admin\\\\PythonProjects\\\\stable-diffusion-webui\\\\models\\\\Codeformer\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"name\": \"GFPGAN\",\n" +
        "    \"cmd_dir\": null\n" +
        "  }\n" +
        "]"));

    List<FaceRestorer> faceRestorers = SdWebui.create("http://localhost:" + client.getPort())
      .getFaceRestorers();
    assertEquals(2, faceRestorers.size());
    assertEquals("CodeFormer", faceRestorers.get(0).getName());
    assertEquals("C:\\Users\\admin\\PythonProjects\\stable-diffusion-webui\\models\\Codeformer", faceRestorers.get(0).getCmdDir());
    assertEquals("GFPGAN", faceRestorers.get(1).getName());
    assertNull(faceRestorers.get(1).getCmdDir());
  }
}