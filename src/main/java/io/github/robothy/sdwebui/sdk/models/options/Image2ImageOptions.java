package io.github.robothy.sdwebui.sdk.models.options;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.Builder.Default;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Image2ImageOptions {

  @JsonProperty("prompt")
  @Default
  private String prompt = "";

  @JsonProperty("negative_prompt")
  @Default
  private String negativePrompt = "";

  @JsonProperty("styles")
  @Default
  private List<String> styles = new ArrayList<>();

  @JsonProperty("seed")
  @Default
  private int seed = -1;

  @JsonProperty("subseed")
  @Default
  private int subseed = -1;

  @JsonProperty("subseed_strength")
  @Default
  private int subseedStrength = 0;

  @JsonProperty("seed_resize_from_h")
  @Default
  private int seedResizeFromH = -1;

  @JsonProperty("seed_resize_from_w")
  @Default
  private int seedResizeFromW = -1;

  @JsonProperty("sampler_name")
  @Default
  private String samplerName = "string";

  @JsonProperty("batch_size")
  @Default
  private int batchSize = 1;

  @JsonProperty("n_iter")
  @Default
  private int nIter = 1;

  @JsonProperty("steps")
  @Default
  private int steps = 50;

  @JsonProperty("cfg_scale")
  @Default
  private double cfgScale = 7;

  @JsonProperty("width")
  @Default
  private int width = 512;

  @JsonProperty("height")
  @Default
  private int height = 512;

  @JsonProperty("restore_faces")
  @Default
  private boolean restoreFaces = true;

  @JsonProperty("tiling")
  @Default
  private boolean tiling = true;

  @JsonProperty("do_not_save_samples")
  @Default
  private boolean doNotSaveSamples = false;

  @JsonProperty("do_not_save_grid")
  @Default
  private boolean doNotSaveGrid = false;

  @JsonProperty("eta")
  @Default
  private int eta = 0;

  @JsonProperty("denoising_strength")
  @Default
  private double denoisingStrength = 0.75;

  @JsonProperty("s_min_uncond")
  @Default
  private int sMinUncond = 0;

  @JsonProperty("s_churn")
  @Default
  private int sChurn = 0;

  @JsonProperty("s_tmax")
  @Default
  private int sTmax = 0;

  @JsonProperty("s_tmin")
  @Default
  private int sTmin = 0;

  @JsonProperty("s_noise")
  @Default
  private int sNoise = 0;

  @JsonProperty("override_settings")
  @Default
  private Map<String, Object> overrideSettings = Collections.emptyMap();

  @JsonProperty("override_settings_restore_afterwards")
  @Default
  private boolean overrideSettingsRestoreAfterwards = false;

  @JsonProperty("refiner_checkpoint")
  @Default
  private String refinerCheckpoint = "";

  @JsonProperty("refiner_switch_at")
  @Default
  private int refinerSwitchAt = 0;

  @JsonProperty("disable_extra_networks")
  @Default
  private boolean disableExtraNetworks = false;

  @JsonProperty("comments")
  @Default
  private Map<String, Object> comments = Collections.emptyMap();

  @JsonProperty("init_images")
  @Default
  private List<String> initImages = new ArrayList<>();

  @JsonProperty("resize_mode")
  @Default
  private int resizeMode = 0;

  @JsonProperty("image_cfg_scale")
  @Default
  private int imageCfgScale = 0;

  @JsonProperty("mask")
  private String mask;

  @JsonProperty("mask_blur_x")
  @Default
  private int maskBlurX = 0;

  @JsonProperty("mask_blur_y")
  @Default
  private int maskBlurY = 0;

  @JsonProperty("mask_blur")
  @Default
  private int maskBlur = 0;

  @JsonProperty("inpainting_fill")
  @Default
  private int inpaintingFill = 0;

  @JsonProperty("inpaint_full_res")
  @Default
  private boolean inpaintFullRes = false;

  @JsonProperty("inpaint_full_res_padding")
  @Default
  private int inpaintingFullResPadding = 0;

  @JsonProperty("inpainting_mask_invert")
  @Default
  private int inpaintingMaskInvert = 0;

  @JsonProperty("initial_noise_multiplier")
  @Default
  private int initialNoiseMultiplier = 0;

  @JsonProperty("latent_mask")
  @Default
  private String latentMask = "";

  @JsonProperty("sampler_index")
  @Default
  @Deprecated
  private String samplerIndex = "";

  @JsonProperty("include_init_images")
  @Default
  private boolean includeInitImages = false;

  @JsonProperty("script_name")
  @Default
  private String scriptName = "";

  @JsonProperty("script_args")
  @Default
  private String[] scriptArgs = new String[]{};

  @JsonProperty("send_images")
  @Default
  private boolean sendImages = true;

  @JsonProperty("save_images")
  @Default
  private boolean saveImages = false;

  @JsonProperty("alwayson_scripts")
  @Default
  private Map<String, Object> alwaysonScripts = Collections.emptyMap();

}
