package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.Toast;

public class ImplicitIntents extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intents);

        ImageButton web = findViewById(R.id.web_button);
        ImageButton call = findViewById(R.id.call_button);
        ImageButton whatsapp = findViewById(R.id.whatsapp_button);
        ImageButton email = findViewById(R.id.email_button);

        web.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://bikaji.com"));
            startActivity(intent);
        });
        call.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:9876543210"));
            startActivity(intent);
        });
        whatsapp.setOnClickListener(v -> {
            String url = "https://api.whatsapp.com/send?phone=9876543210";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });
        email.setOnClickListener(v -> {
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setData(Uri.parse("mailto:"));
            emailIntent.setType("text/plain");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"online@bikaji.com"});
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Prefilled text. Test email from android application.");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Prefilled text. This is message body.");
            try {
                startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                Log.i("Finished sending email.", "");
            } catch (android.content.ActivityNotFoundException ex) {
                Toast t = Toast.makeText(this, "There is no email client installed.", Toast.LENGTH_SHORT);
                t.show();
            }
        });

    }
}