package com.example.components19;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class NetworkChangeReceiver extends BroadcastReceiver {

    //Go to setting, turn off/on wifi to trigger the intent

    @Override
    public void onReceive(Context context, Intent intent) {

        // Get system service object.
        Object systemServiceObj = context.getSystemService(Context.CONNECTIVITY_SERVICE);

        // Convert the service object to ConnectivityManager instance.
        ConnectivityManager connectivityManager = (ConnectivityManager)systemServiceObj;

        // Get network info object.
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        // Check whether network is available or not.
        boolean networkIsAvailable = false;

        if(networkInfo!=null)
        {
            if(networkInfo.isAvailable())
            {
                networkIsAvailable = true;
            }
        }

        // Display message based on whether network is available or not.
        String networkMessage = "";
        if(networkIsAvailable)
        {
            networkMessage = "Great! Network is available";
        }else
        {
            networkMessage = "Alert! Network is not available";
        }

        // Use a toast to show network status info.
        Toast.makeText(context, networkMessage, Toast.LENGTH_LONG).show();

    }
}