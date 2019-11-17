package com.example.components19;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override

    public int onStartCommand(Intent intent, int flags, int startId) {
        //TODO do something useful Recommended by google instead of onStart()
        // finding the time after the operation is executed
        final long start = System.currentTimeMillis();
        final SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor editor = preferences.edit();
        Toast.makeText(getApplicationContext(), "services", Toast.LENGTH_LONG).show();
        //finding the time difference and converting it into seconds
        //createNotification();

                /*
        // something wrong with this thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), "runnable services", Toast.LENGTH_LONG).show();


                AudioManager am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                switch (am.getRingerMode()) {
                    case AudioManager.RINGER_MODE_SILENT:
                        Log.e("MyApp", "Silent mode");
                        break;
                    case AudioManager.RINGER_MODE_VIBRATE:
                        Log.e("MyApp", "Vibrate mode");
                        break;
                    case AudioManager.RINGER_MODE_NORMAL:
                        Log.e("MyApp", "Normal mode");
                        break;

                }
                // finding the time after the operation is executed
                long end = System.currentTimeMillis();
                //finding the time difference and converting it into seconds
                float sec = (end - start) / 1000F;
                System.out.println(sec + " seconds");

                String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String mesg = "Powered on" + timeStamp;
                editor.putString("Time: ", preferences.getString("Time", "") + "\n" + mesg);

                editor.apply();
                editor.commit();

                //Toast.makeText(getApplicationContext(), "You have played"+String.valueOf(sec), Toast.LENGTH_SHORT).show();


                try {
                   mesg = "progress: " + timeStamp;
                    editor.putString("Time: ", preferences.getString("Time", "") + "\n" + mesg);
                    editor.apply();
                    editor.commit();

                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
*/


        return super.onStartCommand(intent, flags, startId);
}

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void createNotification() {
        // Prepare intent which is triggered if the
        // notification is selected
        Intent intent = new Intent(this, null);
        PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);

        // Build notification
        // Actions are just fake
        Notification noti = new Notification.Builder(this)
                .setContentTitle("New mail from " + "test@gmail.com")
                .setContentText("Subject").setSmallIcon(R.drawable.ic_launcher_background)
                .setContentIntent(pIntent)
                .addAction(R.drawable.ic_launcher_background, "Call", pIntent)
                .addAction(R.drawable.ic_launcher_background, "More", pIntent)
                .addAction(R.drawable.ic_launcher_background, "And more", pIntent).build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // hide the notification after its selected
        noti.flags |= Notification.FLAG_AUTO_CANCEL;

        notificationManager.notify(0, noti);

    }

}