package com.reactnativecommunity.blurview;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.graphics.drawable.Drawable;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.util.ReactFindViewUtil;

import java.util.Objects;

import eightbitlab.com.blurview.BlurView;
import eightbitlab.com.blurview.RenderEffectBlur;
import eightbitlab.com.blurview.RenderScriptBlur;

public class CustomBlurView extends BlurView {
  private String imageId;

  public CustomBlurView(Context context) {
    super(context);
  }

  public CustomBlurView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public CustomBlurView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  public void setImageId(String imageId) {
    this.imageId = imageId;
  }

  @Override
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();

    View decorView = Objects
      .requireNonNull(((ThemedReactContext)getContext()).getCurrentActivity())
      .getWindow()
      .getDecorView();

    ViewGroup rootView = decorView.findViewById(android.R.id.content);
    Drawable targetBackground = decorView.getBackground();

    if (this.imageId != null) {
      View bannerImageView = ReactFindViewUtil.findView(rootView, this.imageId);
      if (bannerImageView != null) {
        rootView = (ViewGroup) bannerImageView;
        targetBackground = bannerImageView.getBackground();
      }
    }

    if (Build.VERSION.SDK_INT >= 31) {
      this
        .setupWith((ViewGroup) rootView, new RenderEffectBlur())
        .setFrameClearDrawable(targetBackground)
        .setOverlayColor(0)
        .setBlurRadius(10);
    } else {
      this
        .setupWith((ViewGroup) rootView, new RenderScriptBlur(getContext()))
        .setFrameClearDrawable(targetBackground)
        .setOverlayColor(0)
        .setBlurRadius(10);
    }
  }
}
