package io.github.robothy.sdwebui.sdk;

import io.github.robothy.sdwebui.sdk.models.options.Txt2ImageOptions;
import io.github.robothy.sdwebui.sdk.models.results.Txt2ImgResult;

public interface Txt2Image {

  Txt2ImgResult txt2Img(Txt2ImageOptions options);

}
