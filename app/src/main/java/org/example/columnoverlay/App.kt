package org.example.columnoverlay

import android.app.Application

class App: Application() {

    companion object {
        object TestTags {
            const val OVERLAY_CONTAINER = "OVERLAY_CONTAINER"
        }
    }
}