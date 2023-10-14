package com.practice

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

@BindingAdapter("image")
fun ImageView.setImage(imageUrl:String){
    load(imageUrl){
        crossfade(300)
    }
}

