package com.myproject.sevenwindsstudio

import android.app.Application
import android.content.Context
import android.widget.Toast
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.qualifiers.ApplicationContext

@HiltAndroidApp
class App : Application() {
    companion object {
        var token: String = ""
    }
}
