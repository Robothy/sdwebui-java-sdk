package io.github.robothy.sdwebui.sdk;

import io.github.robothy.sdwebui.sdk.models.options.Txt2ImageOptions;
import io.github.robothy.sdwebui.sdk.models.results.Txt2ImgResult;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

  public static void main(String[] args) throws IOException {
    SdWebui sd = SdWebui.create("http://localhost:7860");

    Txt2ImgResult txt2ImgResult = sd.txt2Img(Txt2ImageOptions.builder()
      .prompt("1girl,beauty")
      .samplerName("DPM++ 2M Karras")
      .build());

    Path filepath = Paths.get("result.html");
    String base64img = txt2ImgResult.getImages().get(0);
    Files.write(filepath, ("<img src=\"data:image/png;base64," + base64img + "\" />").getBytes());
  }

}
