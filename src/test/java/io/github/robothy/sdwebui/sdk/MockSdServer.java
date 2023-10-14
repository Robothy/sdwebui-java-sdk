package io.github.robothy.sdwebui.sdk;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.mockserver.client.MockServerClient;
import org.mockserver.netty.MockServer;

import java.net.http.HttpRequest;
import java.util.List;
import java.util.function.Predicate;

public class MockSdServer implements BeforeAllCallback, BeforeEachCallback, AfterEachCallback {

  private int port;

  public int getPort() {
    return port;
  }

  @Override
  public void afterEach(ExtensionContext context) throws Exception {

  }

  @Override
  public void beforeAll(ExtensionContext context) throws Exception {

  }

  @Override
  public void beforeEach(ExtensionContext context) throws Exception {

  }
}
