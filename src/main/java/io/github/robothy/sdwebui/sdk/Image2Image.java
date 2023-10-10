package io.github.robothy.sdwebui.sdk;

import io.github.robothy.sdwebui.sdk.models.Image2ImageOptions;
import io.github.robothy.sdwebui.sdk.models.Image2ImageResult;

public interface Image2Image {

  Image2ImageResult image2Image(Image2ImageOptions options);

}
