package io.github.robothy.sdwebui.sdk.models;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import javax.imageio.ImageIO;
import org.junit.jupiter.api.Test;

public class ImageFileTest {

  @Test
  void readMetadata() throws Exception {
    BufferedImage img = ImageIO.read(new FileInputStream("C:\\tmp\\Design.png"));

  }

}
