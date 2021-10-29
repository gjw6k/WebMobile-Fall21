package com.example.getpizza;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SumActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        String summary = getIntent().getExtras().getString("summary");
        ((TextView) findViewById(R.id.sum)).setText(summary);
        Log.d("summary", summary);
    }
    public void backToOrder(View view){
        Intent order = new Intent(getBaseContext(),MainActivity.class);
        startActivity(order);

    }
    public void submitOrder(View view) {
        Intent mail = new Intent(Intent.ACTION_SEND);
        mail.setType("text/plain");
        mail.putExtra(Intent.EXTRA_EMAIL, new String[]{"golla.jayanth09@gmail.com"});
        mail.putExtra(Intent.EXTRA_SUBJECT, "Get Pizza Order");

        String summary = getIntent().getExtras().getString("summary");
        mail.putExtra(Intent.EXTRA_TEXT, summary);

        if (mail.resolveActivity(getPackageManager()) != null) {
            startActivity(mail);
        }
    }
}