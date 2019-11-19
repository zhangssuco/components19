package com.example.components19;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;


public class MyReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "Intent before!.", Toast.LENGTH_LONG).show();

        if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {

            Toast.makeText(context, "Boot completed after.", Toast.LENGTH_LONG).show();

        }

        if ("android.intent.action.ACTION_POWER_CONNECTED".equals(intent.getAction())) {

            Toast.makeText(context, "Power completed after.", Toast.LENGTH_LONG).show();


        }
        if ("android.intent.action.ACTION_POWER_DISCONNECTED".equals(intent.getAction())) {

            Toast.makeText(context, "Power disconnected completed after.", Toast.LENGTH_LONG).show();


        }
    }
}