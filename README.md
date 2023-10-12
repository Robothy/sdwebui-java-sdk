# Stable Diffusion Webui Java SDK

sdwebui-java-sdk is a Java library  for building Java applications that integrate with [Stable Diffusion Webui](https://github.com/AUTOMATIC1111/stable-diffusion-webui).

## Usage

### Create `SdWebui` instance

```java
SdWebui sd = SdWebui.create("http://localhost:7860");
```

### Text to Image

```java
    Txt2ImgResult txt2ImgResult = sd.txt2Img(Txt2ImageOptions.builder()
      .prompt("1dog")
      .samplerName("DPM++ 2M Karras")
      .steps(20)
      .cfgScale(7)
      .seed(32749528)
      .build());

    Path step1Path = Paths.get("docs/images/txt2img-dog.png");
    Files.write(step1Path, Base64.getDecoder().decode(txt2ImgResult.getImages().get(0)));
```

![](docs/images/txt2img-dog.png)

### Image to Image

```java
Image2ImageResult image2ImageResult = sd.img2img(Image2ImageOptions.builder()
  .prompt("1dog, glass")
  .negativePrompt("bad fingers")
  .samplerName("DPM++ 2M Karras")
  .seed(32749528)
  .cfgScale(7)
  .denoisingStrength(0.3)
  .initImages(List.of(txt2ImgResult.getImages().get(0)))
  .build());


  String base64img = image2ImageResult.getImages().get(0);

  Path filepath = Paths.get("docs/images/img2img-dog.png");
  Files.write(filepath, Base64.getDecoder().decode(base64img));
```

![](docs/images/img2img-dog.png)