package ru.startandroid.p0992notificationsimple2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnShow;
    private final static String CHANNEL_ID = "CHANNEL_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShow = (Button) findViewById(R.id.btnShow);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // initialize notification manager
                NotificationManager manager = (NotificationManager)
                        getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

                // initialize intent for yes button
                Intent intent1 = new Intent(MainActivity.this, MainActivity2.class);
                // put extra
                intent1.putExtra("yes", true);
                // add flags
                intent1.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                // initialize pending intent
                PendingIntent pendingIntent1 = PendingIntent.getActivity(MainActivity.this,
                        0, intent1, PendingIntent.FLAG_ONE_SHOT);

                // initialize intent for no button
                Intent intent2 = new Intent(MainActivity.this, MainActivity2.class);
                // put extra
                intent2.putExtra("no", false);
                // add flags
                intent2.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                // initialize pending intent
                PendingIntent pendingIntent2 = PendingIntent.getActivity(MainActivity.this,
                        1, intent2, PendingIntent.FLAG_ONE_SHOT);

                // get default ringtone uri
                Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                // Initialize notification builder
                NotificationCompat.Builder builder = new NotificationCompat.Builder(
                        MainActivity.this, getString(R.string.app_name));

                // set notification title
                builder.setContentTitle("Request");
                // set content text
                builder.setContentText("Are you sure you want to accept request?");
                // set icon
                builder.setSmallIcon(R.drawable.ic_notification);
                // set sound
                builder.setSound(uri);
                // set auto cancel
                builder.setAutoCancel(true);
                // set priority
                builder.setPriority(NotificationCompat.PRIORITY_HIGH);
                // perform action on yes button
                builder.addAction(R.drawable.ic_launcher_foreground, "Yes", pendingIntent1);
                // perform action on no button
                builder.addAction(R.drawable.ic_launcher_foreground, "No", pendingIntent2);
                // add notification channel
                createChannelIfNeeded(manager);
                // notify manager
                manager.notify(1, builder.build());

            }
        });
    }

    public static void createChannelIfNeeded(NotificationManager manager) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(
                    CHANNEL_ID, CHANNEL_ID, NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(notificationChannel);
        }
    }
}