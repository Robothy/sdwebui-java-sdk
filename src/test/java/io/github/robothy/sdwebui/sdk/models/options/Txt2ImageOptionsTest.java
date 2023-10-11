package io.github.robothy.sdwebui.sdk.models.options;

import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.robothy.sdwebui.sdk.enums.HiResUpscaler;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class Txt2ImageOptionsTest {

  @Test
  void testSerialization() throws JsonProcessingException {
    Txt2ImageOptions txt2ImageOptions = Txt2ImageOptions.builder()
        .alwaysonScripts(Map.of("s1", "v1"))
        .batchSize(2)
        .eta(0.1)
        .denoisingStrength(0.2)
        .firstphaseHeight(3)
        .firstphaseWidth(4)
        .hrResizeX(5)
        .hrResizeY(6)
        .hrScale(7)
        .hrSecondPassSteps(8)
        .hrUpscaler(HiResUpscaler.Latent)
        .height(9)
        .width(10)
        .doNotSaveGrid(true)
        .enableHr(true)
        .prompt("prompt")
        .nIter(11)
        .doNotSaveSamples(true)
        .negativePrompt("negativePrompt")
        .saveImages(true)
        .overrideSettings(Map.of("s1", "v1"))
        .cfgScale(12)
        .sChurn(13)
        .samplerName("samplerName")
        .samplerIndex("14")
        .sendImages(true)
        .scriptName("scriptName")
        .scriptArgs(List.of("arg1", "arg2"))
        .seed(15)
        .seedResizeFromH(16)
        .seedResizeFromW(17)
        .steps(18)
        .sTmax(19)
        .sNoise(20)
        .sTmin(10)
        .subseed(21)
        .styles(List.of("style1", "style2"))
        .restoreFaces(true)
        .tiling(true)
        .subseedStrength(0.3)
        .useDeprecatedControlnet(true)
        .overrideSettingsRestoreAfterwards(true)
        .build();

    ObjectMapper objectMapper = new ObjectMapper();
    Txt2ImageOptions deserializedTxt2ImageOptions =
        objectMapper.readValue(objectMapper.writeValueAsString(txt2ImageOptions), Txt2ImageOptions.class);
    assertEquals(txt2ImageOptions, deserializedTxt2ImageOptions);
  }

}