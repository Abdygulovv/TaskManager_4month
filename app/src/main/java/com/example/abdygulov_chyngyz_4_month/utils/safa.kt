package com.example.abdygulov_chyngyz_4_month.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.abdygulov_chyngyz_4_month.R

fun ImageView.loadImage(url: String) {
    Glide.with(this).load(url).placeholder(R.drawable.ic_profile).into(this)
}