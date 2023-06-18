package com.example.abdygulov_chyngyz_4_month.data.local

import android.annotation.SuppressLint
import android.content.Context
import android.content.Context.MODE_PRIVATE

class Pref(private val context: Context) {

    private val pref by lazy {
        context.getSharedPreferences(PREF_NAME, MODE_PRIVATE)
    }

    fun isUserSeen(): Boolean {
        return pref.getBoolean(SEEN_KEY, false)
    }

    fun saveSeen() {
        pref.edit().putBoolean(SEEN_KEY, true).apply()
    }

    fun saveName(name: String) {
        pref.edit().putString(SAVE_NAME, name).apply()
    }

    fun getName(): String? {
        return pref.getString(SAVE_NAME, "")
    }

    fun saveImage(image: String) {
        pref.edit().putString(SAVE_IMAGE, image).apply()
    }

    fun getImage(): String? {
        return pref.getString(SAVE_IMAGE, "")
    }

    companion object {
        const val PREF_NAME = "task.pref"
        const val SEEN_KEY = "user.key"
        const val SAVE_NAME = "name.key"
        const val SAVE_IMAGE = "image.key"
    }
}