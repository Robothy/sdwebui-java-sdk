package io.github.robothy.sdwebui.sdk;

import io.github.robothy.sdwebui.sdk.models.options.Image2ImageOptions;
import io.github.robothy.sdwebui.sdk.models.options.Txt2ImageOptions;
import io.github.robothy.sdwebui.sdk.models.results.Image2ImageResult;
import io.github.robothy.sdwebui.sdk.models.results.Txt2ImgResult;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {
    SdWebui sd = SdWebui.create("http://localhost:7860");

    Txt2ImgResult txt2ImgResult = sd.txt2Img(Txt2ImageOptions.builder()
      .prompt("1girl,beauty")
      .samplerName("DPM++ 2M Karras")
      .build());

    Image2ImageResult image2ImageResult = sd.img2img(Image2ImageOptions.builder()
      .prompt("woman")
      .negativePrompt("bad fingers")
      .samplerName("DPM++ 2M Karras")
      .seed(1)
      .cfgScale(7.5)
      .denoisingStrength(0.5)
      .initImages(List.of(txt2ImgResult.getImages().get(0)))
      .build());


    String base64img = image2ImageResult.getImages().get(0);

    Path filepath = Paths.get("result.html");
    Files.write(filepath, ("<img src=\"data:image/png;base64," + base64img + "\" />").getBytes());
  }

}
