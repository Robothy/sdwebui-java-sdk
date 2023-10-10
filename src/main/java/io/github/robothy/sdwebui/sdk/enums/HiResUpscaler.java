package io.github.robothy.sdwebui.sdk.enums;

public enum HiResUpscaler {
  None("None"),
  Latent("Latent"),
  LatentAntialiased("Latent (antialiased)"),
  LatentBicubic("Latent (bicubic)"),
  LatentBicubicAntialiased("Latent (bicubic antialiased)"),
  LatentNearest("Latent (nearist)"),
  LatentNearestExact("Latent (nearist-exact)"),
  Lanczos("Lanczos"),
  Nearest("Nearest"),
  ESRGAN_4x("ESRGAN_4x"),
  LDSR("LDSR"),
  ScuNET_GAN("ScuNET GAN"),
  ScuNET_PSNR("ScuNET PSNR"),
  SwinIR_4x("SwinIR 4x");

  private final String name;

  HiResUpscaler(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}