package io.github.robothy.sdwebui.sdk;

import io.github.robothy.sdwebui.sdk.models.options.Txt2ImageOptions;
import io.github.robothy.sdwebui.sdk.models.results.Txt2ImgResult;

public interface Txt2Image {

  /**
   * Generate images from text.
   *
   * @param options The options to generate images.
   * @return The result of the generation.
   *
   * @throws io.github.robothy.sdwebui.sdk.exceptions.SdWebuiServerValidationException
   * @throws io.github.robothy.sdwebui.sdk.exceptions.SdWebuiBadRequestException
   */
  Txt2ImgResult txt2Img(Txt2ImageOptions options);

}
