package io.github.robothy.sdwebui.sdk.models.options;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Image2ImageOptionsTest {

  @Test
  void testSerialization() throws JsonProcessingException {
    Image2ImageOptions options = Image2ImageOptions.builder()
      .prompt("prompt")
      .negativePrompt("negativePrompt")
      .styles(new ArrayList<>())
      .seed(-1)
      .subseed(-1)
      .subseedStrength(0)
      .seedResizeFromH(-1)
      .seedResizeFromW(-1)
      .samplerName("string")
      .batchSize(1)
      .nIter(1)
      .steps(50)
      .cfgScale(7)
      .width(512)
      .height(512)
      .restoreFaces(true)
      .tiling(true)
      .doNotSaveSamples(false)
      .doNotSaveGrid(false)
      .eta(0)
      .denoisingStrength(0.75)
      .sMinUncond(0)
      .sChurn(0)
      .sTmax(0)
      .sTmin(0)
      .sNoise(0)
      .overrideSettings(Collections.emptyMap())
      .overrideSettingsRestoreAfterwards(false)
      .refinerCheckpoint("checkpoint")
      .refinerSwitchAt(0)
      .disableExtraNetworks(false)
      .comments(Collections.emptyMap())
      .initImages(new ArrayList<>())
      .resizeMode(0)
      .imageCfgScale(0)
      .mask("mask")
      .maskBlurX(0)
      .maskBlurY(0)
      .maskBlur(0)
      .inpaintingFill(0)
      .inpaintFullRes(false)
      .inpaintingFullResPadding(0)
      .inpaintingMaskInvert(0)
      .initialNoiseMultiplier(0)
      .latentMask("latentMask")
      .samplerIndex("sampler")
      .includeInitImages(false)
      .scriptName("Script")
      .scriptArgs(new String[]{})
      .sendImages(true)
      .saveImages(false)
      .alwaysonScripts(Collections.emptyMap())
      .build();

    ObjectMapper mapper = new ObjectMapper();
    String json = mapper.writeValueAsString(options);
    Image2ImageOptions deserializedOptions = mapper.readValue(json, Image2ImageOptions.class);
    assertEquals(options, deserializedOptions);
  }

}