package io.github.robothy.sdwebui.sdk.utils;

import com.sun.imageio.plugins.png.PNGMetadata;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataFormat;
import javax.imageio.metadata.IIOMetadataFormatImpl;
import javax.imageio.metadata.IIOMetadataNode;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ImageConverter {

  public static String toBase64PNG(String base64) {
    try {
      byte[] imgBytes = Base64.getDecoder().decode(base64);
      Map<String, String> meta = readMetadata(imgBytes);
      System.out.println(meta);
      BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(imgBytes));
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      ImageIO.write(bufferedImage, "png", out);
      return Base64.getEncoder().encodeToString(out.toByteArray());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static Map<String, String> readMetadata(byte[] imageBytes) {
    try {
      ImageReader imageReader = ImageIO.getImageReadersByFormatName("png").next();
      imageReader.setInput(ImageIO.createImageInputStream(new ByteArrayInputStream(imageBytes)), true);

      // read metadata of first image
      IIOMetadata metadata = imageReader.getImageMetadata(0);

      IIOMetadataFormat metadataFormat = metadata.getMetadataFormat(IIOMetadataFormatImpl.standardMetadataFormatName);
      Node n = metadata.getAsTree(IIOMetadataFormatImpl.standardMetadataFormatName);
      n.getChildNodes().getLength()

      //this cast helps getting the contents
      PNGMetadata pngmeta = (PNGMetadata) metadata;
      NodeList childNodes = pngmeta.getStandardTextNode().getChildNodes();




      Map<String, String> meta = new HashMap<>();
      for (int i = 0; i < childNodes.getLength(); i++) {
        Node node = childNodes.item(i);
        String keyword = node.getAttributes().getNamedItem("keyword").getNodeValue();
        String value = node.getAttributes().getNamedItem("value").getNodeValue();
        meta.put(keyword, value);
      }
      return meta;
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }



}
