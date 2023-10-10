package io.github.robothy.sdwebui.sdk;

import io.github.robothy.sdwebui.sdk.services.DefaultSdWebuiBeanContainer;

public interface SdWebuiBeanContainer {

  static SdWebuiBeanContainer create(String endpoint) {
    return new DefaultSdWebuiBeanContainer(endpoint);
  }

  <T> T getBean(Class<T> serviceClass);

  void register(Class<?> serviceClass, Object service);

}
