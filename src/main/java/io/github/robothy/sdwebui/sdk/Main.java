package io.github.robothy.sdwebui.sdk;

import io.github.robothy.sdwebui.sdk.models.options.Image2ImageOptions;
import io.github.robothy.sdwebui.sdk.models.options.Txt2ImageOptions;
import io.github.robothy.sdwebui.sdk.models.results.Image2ImageResult;
import io.github.robothy.sdwebui.sdk.models.results.Txt2ImgResult;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {
    SdWebui sd = SdWebui.create("http://localhost:7860");

    Txt2ImgResult txt2ImgResult = sd.txt2Img(Txt2ImageOptions.builder()
      .prompt("1dog")
      .samplerName("DPM++ 2M Karras")
      .steps(20)
      .cfgScale(7)
      .seed(32749528)
      .build());

    Path step1Path = Paths.get("docs/images/txt2img-dog.png");
    Files.write(step1Path, Base64.getDecoder().decode(txt2ImgResult.getImages().get(0)));

    Image2ImageResult image2ImageResult = sd.img2img(Image2ImageOptions.builder()
      .prompt("1dog, glass")
      .negativePrompt("bad fingers")
      .samplerName("DPM++ 2M Karras")
      .seed(32749528)
      .cfgScale(7)
      .denoisingStrength(0.3)
      .initImages(List.of(txt2ImgResult.getImages().get(0)))
      .build());


    String base64img = image2ImageResult.getImages().get(0);

    Path filepath = Paths.get("docs/images/img2img-dog.png");
    Files.write(filepath, Base64.getDecoder().decode(base64img));
  }

}
