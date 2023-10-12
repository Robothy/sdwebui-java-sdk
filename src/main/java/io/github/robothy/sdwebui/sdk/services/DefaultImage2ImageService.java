package io.github.robothy.sdwebui.sdk.services;

import io.github.robothy.sdwebui.sdk.Image2Image;
import io.github.robothy.sdwebui.sdk.SdWebuiBeanContainer;
import io.github.robothy.sdwebui.sdk.models.SystemInfo;
import io.github.robothy.sdwebui.sdk.models.options.Image2ImageOptions;
import io.github.robothy.sdwebui.sdk.models.results.Image2ImageResult;
import io.github.robothy.sdwebui.sdk.utils.JsonUtils;
import io.github.robothy.sdwebui.sdk.utils.SdWebuiResponseUtils;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpHeaders;
import org.apache.hc.core5.http.io.entity.StringEntity;

import java.io.IOException;

public class DefaultImage2ImageService implements Image2Image {

  private static final String IMG2IMG_PATH = "/sdapi/v1/img2img";

  private final SdWebuiBeanContainer container;

  public DefaultImage2ImageService(SdWebuiBeanContainer container) {
    this.container = container;
  }

  @Override
  public Image2ImageResult img2img(Image2ImageOptions options) {
    HttpClient httpClient = container.getBean(HttpClient.class);
    try {
      return httpClient.execute(buildRequest(options), this::parseResponse);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  ClassicHttpRequest buildRequest(Image2ImageOptions options) {
    String url = container.getBean(SystemInfo.class).getEndpoint() + IMG2IMG_PATH;
    ClassicHttpRequest request = new HttpPost(url);
    request.setEntity(new StringEntity(JsonUtils.toJson(options)));
    request.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
    return request;
  }

  Image2ImageResult parseResponse(ClassicHttpResponse response) {
    SdWebuiResponseUtils.checkResponseStatus(response);
    try {
      return JsonUtils.fromJson(response.getEntity().getContent(), Image2ImageResult.class);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
