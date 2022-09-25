package com.example.lab2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import java.util.Date;

public class Notification extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        Button ch1 = findViewById(R.id.ch1);
        Button ch2 = findViewById(R.id.ch2);

        ch1.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), FragmentActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_IMMUTABLE);

            createNotificationChannel();
            NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), "CHANNEL_ID")
                    .setSmallIcon(R.drawable.logo1)
                    .setContentTitle("Hey, Come Back! \n")
                    .setContentText("Checkout newly added products.")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setWhen((new Date()).getTime())
                    .setShowWhen(true)
                    .setColorized(true)
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);

            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplicationContext());
            notificationManager.notify(1, builder.build());
        });
        ch2.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), ImplicitIntents.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_IMMUTABLE);

            createNotificationChannel();
            NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), "CHANNEL_ID")
                    .setSmallIcon(R.drawable.logo1)
                    .setContentTitle("Get Support 24x7! \n")
                    .setContentText("Click to view support options.")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setWhen((new Date()).getTime())
                    .setShowWhen(true)
                    .setColorized(true)
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);

            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplicationContext());
            notificationManager.notify(2, builder.build());
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createNotificationChannel() {

        int importance = NotificationManager.IMPORTANCE_DEFAULT;
        NotificationChannel channel = new NotificationChannel("CHANNEL_ID", "App Notification", importance);
        channel.setDescription("Click");

        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);
    }
}