package io.github.robothy.sdwebui.sdk;

import io.github.robothy.sdwebui.sdk.models.SdWebuiOptions;
import io.github.robothy.sdwebui.sdk.services.DefaultSdWebuiBeanContainer;

public interface SdWebuiBeanContainer {

  static SdWebuiBeanContainer create(SdWebuiOptions options) {
    return new DefaultSdWebuiBeanContainer(options);
  }

  <T> T getBean(Class<T> serviceClass);

  void register(Class<?> serviceClass, Object service);

}
