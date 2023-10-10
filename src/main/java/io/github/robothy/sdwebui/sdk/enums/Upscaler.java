package io.github.robothy.sdwebui.sdk.enums;

public enum Upscaler {
  None("None"),
  Lanczos("Lanczos"),
  Nearest("Nearest"),
  LDSR("LDSR"),
  BSRGAN("BSRGAN"),
  ESRGAN_4x("ESRGAN_4x"),
  R_ESRGAN_General_4xV3("R-ESRGAN General 4xV3"),
  ScuNET_GAN("ScuNET GAN"),
  ScuNET_PSNR("ScuNET PSNR"),
  SwinIR_4x("SwinIR 4x");

  private final String name;

  Upscaler(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}