package com.reactnativecommunity.blurview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.AndroidBlurViewManagerDelegate;
import com.facebook.react.viewmanagers.AndroidBlurViewManagerInterface;

import eightbitlab.com.blurview.BlurView;

@ReactModule(name = BlurViewManagerImpl.REACT_CLASS)
class BlurViewManager extends ViewGroupManager<CustomBlurView>
    implements AndroidBlurViewManagerInterface<CustomBlurView> {

  private final ViewManagerDelegate<CustomBlurView> mDelegate;

  public BlurViewManager(ReactApplicationContext context) {
    mDelegate = new AndroidBlurViewManagerDelegate<>(this);
  }

  @Nullable
  @Override
  protected ViewManagerDelegate<BlurView> getDelegate() {
    return mDelegate;
  }

  @NonNull
  @Override
  public String getName() {
    return BlurViewManagerImpl.REACT_CLASS;
  }

  @NonNull
  @Override
  protected CustomBlurView createViewInstance(@NonNull ThemedReactContext context) {
    return BlurViewManagerImpl.createViewInstance(context);
  }

  @Override
  @ReactProp(name = "blurRadius", defaultInt = BlurViewManagerImpl.defaultRadius)
  public void setBlurRadius(CustomBlurView view, int radius) {
    BlurViewManagerImpl.setRadius(view, radius);
  }

  @Override
  @ReactProp(name = "overlayColor", customType = "Color")
  public void setOverlayColor(CustomBlurView view, Integer color) {
    BlurViewManagerImpl.setColor(view, color);
  }

  @Override
  @ReactProp(name = "downsampleFactor", defaultInt = BlurViewManagerImpl.defaultSampling)
  public void setDownsampleFactor(CustomBlurView view, int factor) {}

  @Override
  @ReactProp(name = "autoUpdate", defaultBoolean = true)
  public void setAutoUpdate(CustomBlurView view, boolean autoUpdate) {
    BlurViewManagerImpl.setAutoUpdate(view, autoUpdate);
  }

  @Override
  @ReactProp(name = "enabled", defaultBoolean = true)
  public void setEnabled(CustomBlurView view, boolean enabled) {
    BlurViewManagerImpl.setBlurEnabled(view, enabled);
  }

  @Override
  @ReactProp(name = "imageId")
  public void setImageId(CustomBlurView view, String imageId) {
    BlurViewManagerImpl.setImageId(view, imageId);
  }

  @Override
  public void setBlurAmount(CustomBlurView view, int value) {}

  @Override
  public void setBlurType(CustomBlurView view, @Nullable String value) {}
}
