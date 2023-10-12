package io.github.robothy.sdwebui.sdk;

import io.github.robothy.sdwebui.sdk.models.options.Image2ImageOptions;
import io.github.robothy.sdwebui.sdk.models.results.Image2ImageResult;

public interface Image2Image {

  Image2ImageResult img2img(Image2ImageOptions options);

}
