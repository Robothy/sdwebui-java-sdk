package io.github.robothy.sdwebui.sdk;


import io.github.robothy.sdwebui.sdk.services.SdWebuiInvocationHandler;

import java.lang.reflect.Proxy;

public interface SdWebui extends Txt2Image, SystemInfoFetcher {

  static SdWebui create(String endpoint) {
    return (SdWebui) Proxy.newProxyInstance(SdWebui.class.getClassLoader(), new Class[]{SdWebui.class}, new SdWebuiInvocationHandler(endpoint));
  }

}
