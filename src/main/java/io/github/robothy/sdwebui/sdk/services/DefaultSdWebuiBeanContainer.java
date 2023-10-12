package io.github.robothy.sdwebui.sdk.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.robothy.sdwebui.sdk.*;
import io.github.robothy.sdwebui.sdk.models.SystemInfo;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;

import java.util.HashMap;
import java.util.Map;

public class DefaultSdWebuiBeanContainer implements SdWebuiBeanContainer {

  private final Map<Class<?>, Object> services;

  private final String endpoint;

  public DefaultSdWebuiBeanContainer(String endpoint) {
    this.services = new HashMap<>();
    this.endpoint = endpoint;
    init();
  }

  @SuppressWarnings("unchecked")
  @Override
  public <T> T getBean(Class<T> serviceClass) {
    T instance = (T) this.services.get(serviceClass);
    if (instance == null) {
      throw new RuntimeException("No service or service factory found for " + serviceClass);
    }

    if (instance instanceof SdWebuiBeanFactory) {
        return ((SdWebuiBeanFactory<T>) instance).getBean(this);
    }

    return instance;
  }

  @Override
  public void register(Class<?> serviceClass, Object service) {
    this.services.put(serviceClass, service);
  }

  private void init() {
    CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
    this.services.put(ObjectMapper.class, new ObjectMapper());
    this.services.put(HttpClient.class, closeableHttpClient);
    this.services.put(SystemInfo.class, new CacheableSystemInfoFetcher(endpoint, this));
    this.services.put(Txt2Image.class, new DefaultTxt2ImageService(this));
    this.services.put(Image2Image.class, new DefaultImage2ImageService(this));
  }

}
