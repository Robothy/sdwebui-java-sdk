package io.github.robothy.sdwebui.sdk.services;

import io.github.robothy.sdwebui.sdk.Image2Image;
import io.github.robothy.sdwebui.sdk.models.Image2ImageOptions;
import io.github.robothy.sdwebui.sdk.models.Image2ImageResult;

public class DefaultImage2ImageService implements Image2Image {

  @Override
  public Image2ImageResult image2Image(Image2ImageOptions options) {
    System.out.println("image2Image");
    return null;
  }

}
