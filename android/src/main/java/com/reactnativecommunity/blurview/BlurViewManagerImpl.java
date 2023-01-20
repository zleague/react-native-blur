package com.reactnativecommunity.blurview;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.util.ReactFindViewUtil;

import eightbitlab.com.blurview.BlurView;
import eightbitlab.com.blurview.RenderEffectBlur;
import eightbitlab.com.blurview.RenderScriptBlur;

import java.util.Objects;
import javax.annotation.Nonnull;

@SuppressWarnings("unused")
class BlurViewManagerImpl {

  public static final String REACT_CLASS = "AndroidBlurView";

  public static final int defaultRadius = 10;
  public static final int defaultSampling = 10;

  public static @Nonnull CustomBlurView createViewInstance(@Nonnull ThemedReactContext ctx) {
    CustomBlurView blurView = new CustomBlurView(ctx);
    return blurView;
  }

  public static void setRadius(CustomBlurView view, int radius) {
    view.setBlurRadius(radius);
    view.invalidate();
  }

  public static void setColor(CustomBlurView view, int color) {
    view.setOverlayColor(color);
    view.invalidate();
  }

  public static void setDownsampleFactor(CustomBlurView view, int factor) {}

  public static void setAutoUpdate(CustomBlurView view, boolean autoUpdate) {
    view.setBlurAutoUpdate(autoUpdate);
    view.invalidate();
  }

  public static void setBlurEnabled(CustomBlurView view, boolean enabled) {
    view.setBlurEnabled(enabled);
  }

  public static void setImageId(CustomBlurView view, String imageId) {
    view.setImageId(imageId);
    view.invalidate();
  }
}
