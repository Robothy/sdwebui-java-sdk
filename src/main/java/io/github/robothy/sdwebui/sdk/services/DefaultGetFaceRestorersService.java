package io.github.robothy.sdwebui.sdk.services;

import io.github.robothy.sdwebui.sdk.GetFaceRestorers;
import io.github.robothy.sdwebui.sdk.SdWebuiBeanContainer;
import io.github.robothy.sdwebui.sdk.models.results.FaceRestorer;

import java.util.Arrays;
import java.util.List;

public class DefaultGetFaceRestorersService implements GetFaceRestorers {

  private final SdWebuiBeanContainer container;

  public DefaultGetFaceRestorersService(SdWebuiBeanContainer container) {
    this.container = container;
  }

  @Override
  public List<FaceRestorer> getFaceRestorers() {
    return Arrays.asList(container.getBean(CommonGetService.class).getData("/sdapi/v1/face-restorers", FaceRestorer[].class));
  }

}
