package io.github.robothy.sdwebui.sdk.services;

import io.github.robothy.sdwebui.sdk.GetSdModels;
import io.github.robothy.sdwebui.sdk.SdWebuiBeanContainer;
import io.github.robothy.sdwebui.sdk.models.results.SdModel;

import java.util.Arrays;
import java.util.List;

public class DefaultGetSdModelService implements GetSdModels {

  private final SdWebuiBeanContainer container;

  public DefaultGetSdModelService(SdWebuiBeanContainer container) {
    this.container = container;
  }

  @Override
  public List<SdModel> getSdModels() {
    return Arrays.asList(this.container.getBean(CommonGetService.class).getData("/sdapi/v1/sd-models", SdModel[].class));
  }

}
