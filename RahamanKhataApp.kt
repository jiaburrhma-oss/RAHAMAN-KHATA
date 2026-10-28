package com.rahamankhata.app

import android.app.Application
import com.rahamankhata.app.data.local.KhataDatabase

class RahamanKhataApp : Application() {
    val database: KhataDatabase by lazy { KhataDatabase.getDatabase(this) }

    override fun onCreate() {
        super.onCreate()
    }
}
