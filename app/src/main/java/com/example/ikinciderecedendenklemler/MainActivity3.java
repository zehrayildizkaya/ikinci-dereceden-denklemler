package com.example.ikinciderecedendenklemler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity3 extends AppCompatActivity {
    private Button btnstart;
    private Button btnstop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        btnstart = findViewById(R.id.servis1);
        btnstop = findViewById(R.id.servis2);

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startHelloService();
            }
        });

        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopHelloService();
            }
        });
    }
    public void startHelloService() {
        Intent intent = new Intent(getApplicationContext(),HelloService.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(intent);
        } else {
            startService(intent);
        }
    }

    public void stopHelloService() {
        Intent intent = new Intent(getApplicationContext(),HelloService.class);
        stopService(intent);
    }

}