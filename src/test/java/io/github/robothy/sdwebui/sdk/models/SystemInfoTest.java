package io.github.robothy.sdwebui.sdk.models;

import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

class SystemInfoTest {

  @Test
  void testSerialization() throws JsonProcessingException {
    SystemInfo systemInfo = new SystemInfo();
    systemInfo.setPlatform("Linux");
    systemInfo.setPythonVersion("3.8.5");
    systemInfo.setSdwebuiVersion("0.0.1");
    ObjectMapper objectMapper = new ObjectMapper();
    assertEquals(systemInfo, objectMapper
        .readValue(objectMapper.writeValueAsString(systemInfo), SystemInfo.class));
  }

}