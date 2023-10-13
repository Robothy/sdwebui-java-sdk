package io.github.robothy.sdwebui.sdk.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.robothy.sdwebui.sdk.SdWebuiBeanContainer;
import io.github.robothy.sdwebui.sdk.Txt2Image;
import io.github.robothy.sdwebui.sdk.models.SdWebuiOptions;
import io.github.robothy.sdwebui.sdk.models.SystemInfo;
import io.github.robothy.sdwebui.sdk.models.options.Txt2ImageOptions;
import io.github.robothy.sdwebui.sdk.models.results.Txt2ImgResult;
import io.github.robothy.sdwebui.sdk.utils.SdWebuiResponseUtils;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.StringEntity;

import java.io.IOException;

public class DefaultTxt2ImageService implements Txt2Image {

  private static final String TXT2IMG_PATH = "/sdapi/v1/txt2img";

  private final SdWebuiBeanContainer beanContainer;

  public DefaultTxt2ImageService(SdWebuiBeanContainer beanContainer) {
    this.beanContainer = beanContainer;
  }

  @Override
  public Txt2ImgResult txt2Img(Txt2ImageOptions options) {
    HttpClient httpClient = this.beanContainer.getBean(HttpClient.class);
    ClassicHttpRequest txt2ImgRequest = buildTxt2ImageRequest(options);
    try {
      return httpClient.execute(txt2ImgRequest, this::parseTxt2ImageResult);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  ClassicHttpRequest buildTxt2ImageRequest(Txt2ImageOptions options) {
    SdWebuiOptions sdWebuiOptions = this.beanContainer.getBean(SdWebuiOptions.class);
    HttpPost httpPost = new HttpPost(sdWebuiOptions.getEndpoint() + TXT2IMG_PATH);
    HttpEntity entity = buildTxt2ImageRequestEntity(options);
    httpPost.setEntity(entity);
    httpPost.addHeader("Content-Type", "application/json");
    return httpPost;
  }

  HttpEntity buildTxt2ImageRequestEntity(Txt2ImageOptions options) {
    try {
      String payload = this.beanContainer.getBean(ObjectMapper.class)
        .writeValueAsString(options);
      return new StringEntity(payload);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

  Txt2ImgResult parseTxt2ImageResult(ClassicHttpResponse response) {

    SdWebuiResponseUtils.checkResponseStatus(response);

    try {
      return this.beanContainer.getBean(ObjectMapper.class)
        .readValue(response.getEntity().getContent(), Txt2ImgResult.class);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }

}
