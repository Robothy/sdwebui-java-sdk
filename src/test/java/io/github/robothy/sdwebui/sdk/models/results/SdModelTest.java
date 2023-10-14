package io.github.robothy.sdwebui.sdk.models.results;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.robothy.sdwebui.sdk.SdWebui;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockserver.client.MockServerClient;
import org.mockserver.junit.jupiter.MockServerExtension;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockServerExtension.class)
class SdModelTest {

  private static final String JSON = "{\n" +
    "    \"title\": \"v1-5-pruned-emaonly.ckpt [cc6cb27103]\",\n" +
    "    \"model_name\": \"v1-5-pruned-emaonly\",\n" +
    "    \"hash\": \"cc6cb27103\",\n" +
    "    \"sha256\": \"cc6cb27103417325ff94f52b7a5d2dde45a7515b25c255d8e396c90014281516\",\n" +
    "    \"filename\": \"C:\\\\Users\\\\admin\\\\PythonProjects\\\\stable-diffusion-webui\\\\models\\\\Stable-diffusion\\\\v1-5-pruned-emaonly.ckpt\",\n" +
    "    \"config\": null\n" +
    "}";

  @Test
  void testSerialization() throws JsonProcessingException {
    SdModel sdModel = new ObjectMapper().readValue(JSON, SdModel.class);
    assertEquals("v1-5-pruned-emaonly.ckpt [cc6cb27103]", sdModel.getTitle());
    assertEquals("v1-5-pruned-emaonly", sdModel.getModelName());
    assertEquals("cc6cb27103", sdModel.getHash());
    assertEquals("cc6cb27103417325ff94f52b7a5d2dde45a7515b25c255d8e396c90014281516", sdModel.getSha256());
    assertEquals("C:\\Users\\admin\\PythonProjects\\stable-diffusion-webui\\models\\Stable-diffusion\\v1-5-pruned-emaonly.ckpt", sdModel.getFilename());
    assertNull(sdModel.getConfig());
  }

  @Test
  void getGetSdModels(MockServerClient client) {
    client.when(new HttpRequest().withMethod("GET").withPath("/sdapi/v1/sd-models"))
      .respond(new HttpResponse().withStatusCode(200).withBody("  [" +
        "{\n" +
        "    \"title\": \"MoyouArtificial_v10502g.safetensors [b6c1edcbe9]\",\n" +
        "    \"model_name\": \"MoyouArtificial_v10502g\",\n" +
        "    \"hash\": \"b6c1edcbe9\",\n" +
        "    \"sha256\": \"b6c1edcbe9ef9fa3d38c3787d351211a775e6254b832234d97042800f33345d1\",\n" +
        "    \"filename\": \"C:\\\\Users\\\\admin\\\\PythonProjects\\\\stable-diffusion-webui\\\\models\\\\Stable-diffusion\\\\MoyouArtificial_v10502g.safetensors\",\n" +
        "    \"config\": null\n" +
        "  },\n" +
        "  {\n" +
        "    \"title\": \"v1-5-pruned-emaonly.ckpt [cc6cb27103]\",\n" +
        "    \"model_name\": \"v1-5-pruned-emaonly\",\n" +
        "    \"hash\": \"cc6cb27103\",\n" +
        "    \"sha256\": \"cc6cb27103417325ff94f52b7a5d2dde45a7515b25c255d8e396c90014281516\",\n" +
        "    \"filename\": \"C:\\\\Users\\\\admin\\\\PythonProjects\\\\stable-diffusion-webui\\\\models\\\\Stable-diffusion\\\\v1-5-pruned-emaonly.ckpt\",\n" +
        "    \"config\": null\n" +
        "  }\n" +
        "]"));
    List<SdModel> sdModels = SdWebui.create("http://localhost:" + client.remoteAddress().getPort()).getSdModels();
    assertEquals(2, sdModels.size());
    assertEquals("MoyouArtificial_v10502g.safetensors [b6c1edcbe9]", sdModels.get(0).getTitle());
    assertEquals("v1-5-pruned-emaonly.ckpt [cc6cb27103]", sdModels.get(1).getTitle());
    assertEquals("MoyouArtificial_v10502g", sdModels.get(0).getModelName());
    assertEquals("v1-5-pruned-emaonly", sdModels.get(1).getModelName());
    assertEquals("b6c1edcbe9", sdModels.get(0).getHash());
    assertEquals("cc6cb27103", sdModels.get(1).getHash());
    assertEquals("b6c1edcbe9ef9fa3d38c3787d351211a775e6254b832234d97042800f33345d1", sdModels.get(0).getSha256());
    assertEquals("cc6cb27103417325ff94f52b7a5d2dde45a7515b25c255d8e396c90014281516", sdModels.get(1).getSha256());
    assertEquals("C:\\Users\\admin\\PythonProjects\\stable-diffusion-webui\\models\\Stable-diffusion\\MoyouArtificial_v10502g.safetensors", sdModels.get(0).getFilename());
    assertEquals("C:\\Users\\admin\\PythonProjects\\stable-diffusion-webui\\models\\Stable-diffusion\\v1-5-pruned-emaonly.ckpt", sdModels.get(1).getFilename());
    assertNull(sdModels.get(0).getConfig());
    assertNull(sdModels.get(1).getConfig());
  }

}