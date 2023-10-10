package io.github.robothy.sdwebui.sdk;

public interface SdWebuiBeanFactory<T> {

  T getBean(SdWebuiBeanContainer beanContainer);

}
