package io.github.robothy.sdwebui.sdk.models.options;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.robothy.sdwebui.sdk.enums.HiResUpscaler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Txt2ImageOptions {


  @Builder.Default
  @JsonProperty("enable_hr")
  private boolean enableHr = false;

  @Builder.Default
  @JsonProperty("denoising_strength")
  private double denoisingStrength = 0.7;

  @Builder.Default
  @JsonProperty("firstphase_width")
  private int firstphaseWidth = 0;

  @Builder.Default
  @JsonProperty("firstphase_height")
  private int firstphaseHeight = 0;

  @Builder.Default
  @JsonProperty("hr_scale")
  private int hrScale = 2;

  @Builder.Default
  @JsonProperty("hr_upscaler")
  private HiResUpscaler hrUpscaler = HiResUpscaler.Latent;

  @Builder.Default
  @JsonProperty("hr_second_pass_steps")
  private int hrSecondPassSteps = 0;

  @Builder.Default
  @JsonProperty("hr_resize_x")
  private int hrResizeX = 0;

  @Builder.Default
  @JsonProperty("hr_resize_y")
  private int hrResizeY = 0;

  @Builder.Default
  @JsonProperty("prompt")
  private String prompt = "";

  @Builder.Default
  @JsonProperty("styles")
  private String[] styles = new String[]{};

  @Builder.Default
  @JsonProperty("seed")
  private long seed = -1L;

  @Builder.Default
  @JsonProperty("subseed")
  private long subseed = -1L;

  @Builder.Default
  @JsonProperty("subseed_strength")
  private double subseedStrength = 0.0;

  @Builder.Default
  @JsonProperty("seed_resize_from_h")
  private int seedResizeFromH = 0;

  @Builder.Default
  @JsonProperty("seed_resize_from_w")
  private int seedResizeFromW = 0;

  @Builder.Default
  @JsonProperty("sampler_name")
  private String samplerName = "DPM++ 2M Karras";

  @Builder.Default
  @JsonProperty("batch_size")
  private int batchSize = 1;

  @Builder.Default
  @JsonProperty("n_iter")
  private int nIter = 1;

  @Builder.Default
  @JsonProperty("steps")
  private Integer steps = null;

  @Builder.Default
  @JsonProperty("cfg_scale")
  private double cfgScale = 7.0;

  @Builder.Default
  @JsonProperty("width")
  private int width = 512;

  @Builder.Default
  @JsonProperty("height")
  private int height = 512;

  @Builder.Default
  @JsonProperty("restore_faces")
  private boolean restoreFaces = false;

  @Builder.Default
  @JsonProperty("tiling")
  private boolean tiling = false;

  @Builder.Default
  @JsonProperty("do_not_save_samples")
  private boolean doNotSaveSamples = false;

  @Builder.Default
  @JsonProperty("do_not_save_grid")
  private boolean doNotSaveGrid = false;

  @Builder.Default
  @JsonProperty("negative_prompt")
  private String negativePrompt = "";

  @Builder.Default
  @JsonProperty("eta")
  private double eta = 1.0;

  @Builder.Default
  @JsonProperty("s_churn")
  private int sChurn = 0;

  @Builder.Default
  @JsonProperty("s_tmax")
  private int sTmax = 0;

  @Builder.Default
  @JsonProperty("s_tmin")
  private int sTmin = 0;

  @Builder.Default
  @JsonProperty("s_noise")
  private int sNoise = 1;

  @Builder.Default
  @JsonProperty("override_settings")
  private Map<String, Object> overrideSettings = null;

  @Builder.Default
  @JsonProperty("override_settings_restore_afterwards")
  private boolean overrideSettingsRestoreAfterwards = true;

  @Builder.Default
  @JsonProperty("script_args")
  private String[] scriptArgs = new String[]{};

  @Builder.Default
  @JsonProperty("script_name")
  private String scriptName = null;

  @Builder.Default
  @JsonProperty("send_images")
  private boolean sendImages = true;

  @Builder.Default
  @JsonProperty("save_images")
  private boolean saveImages = false;

  @Builder.Default
  @JsonProperty("alwayson_scripts")
  private Map<String, Object> alwaysonScripts = null;

  @Builder.Default
  @JsonProperty("sampler_index")
  private String samplerIndex = null;

  @Builder.Default
  @JsonProperty("use_deprecated_controlnet")
  private boolean useDeprecatedControlnet = false;

}