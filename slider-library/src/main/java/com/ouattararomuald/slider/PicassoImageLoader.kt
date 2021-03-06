package com.ouattararomuald.slider

import android.support.annotation.DrawableRes
import android.widget.ImageView
import com.squareup.picasso.Picasso

/** Loads images image using [Picasso]. */
class PicassoImageLoader(
  /** An error drawable to be used if the request image could not be loaded. */
  @DrawableRes private val errorResId: Int,
  /**
   * A placeholder drawable to be used while the image is being loaded. If the requested image is
   * not immediately available in the memory cache then this resource will be set on the target
   * [ImageView].
   */
  @DrawableRes private val placeholderResId: Int
) : ImageLoader {

  /** Loads an image into the given [imageView] using the specified path. */
  override fun load(path: String, imageView: ImageView) {
    Picasso.get().load(path).apply {
      if (placeholderResId > 0) {
        placeholder(placeholderResId)
      }
      if (errorResId > 0) {
        error(errorResId)
      }
      fit()
      into(imageView)
    }
  }
}
