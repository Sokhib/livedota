package com.sokhibdzhon.livedota.util.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.sokhibdzhon.livedota.R


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov   ║
╠═══════════════════════════════════════╣
║ sokhibsaid@gmail.com                  ║
╚═══════════════════════════════════════╝
 */

@BindingAdapter("url")
fun loadImage(imageView: ImageView, url: String?) {
    if (url.isNullOrEmpty()) {
        return
    }
    Glide.with(imageView.context)
        .load(url)
        .centerInside()
        .placeholder(R.drawable.dota_2_icon)
        .into(imageView)
}