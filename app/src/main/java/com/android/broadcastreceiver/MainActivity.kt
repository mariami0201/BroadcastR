package com.android.broadcastreceiver

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity() {
    lateinit var receiver: ScreenReceiver
    lateinit var offreceiver: ScreenOffReceiver
    lateinit var creceiver: ChargerReceiver
    lateinit var dcreceiver: DisChargerReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        receiver = ScreenReceiver()
        IntentFilter(Intent.ACTION_SCREEN_OFF).also {
            registerReceiver(receiver, it)
        }

        setContentView(R.layout.activity_main)
        offreceiver = ScreenOffReceiver()
        IntentFilter(Intent.ACTION_SCREEN_ON).also {
            registerReceiver(offreceiver, it)
        }
        setContentView(R.layout.activity_main)
        creceiver = ChargerReceiver()
        IntentFilter(Intent.ACTION_POWER_CONNECTED).also {
            registerReceiver(creceiver, it)
        }
        setContentView(R.layout.activity_main)
        dcreceiver = DisChargerReceiver()
        IntentFilter(Intent.ACTION_POWER_DISCONNECTED).also {
            registerReceiver(dcreceiver, it)
        }
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
        unregisterReceiver(creceiver)
        unregisterReceiver(dcreceiver)
    }

}

