package com.android.broadcastreceiver

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
val currentDate = sdf.format(Date())
class DisChargerReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val isEnabled = intent?.getBooleanExtra("state", true)
        if (isEnabled == true) {
            Toast.makeText(context, "Charger Disconnected - $currentDate", Toast.LENGTH_LONG).show()
        }
    }
}

class ChargerReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val isEnabled = intent?.getBooleanExtra("state", false)
        if (isEnabled == false) {
            Toast.makeText(context, "Charger Connected - $currentDate", Toast.LENGTH_LONG).show()
        }
    }

}
class ScreenOffReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val isEnabled = intent?.getBooleanExtra("state", true)
        if (isEnabled == true) {
            Toast.makeText(context, "Screen On - $currentDate", Toast.LENGTH_LONG).show()
        }
    }
}
class ScreenReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val isEnabled = intent?.getBooleanExtra("state", false)
        if (isEnabled == false) {
            Toast.makeText(context, "Screen Off - $currentDate", Toast.LENGTH_LONG).show()
        }
    }
}