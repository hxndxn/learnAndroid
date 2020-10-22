package com.example.forceoffline;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BroadcastActivity extends BaseActivity {

    private LocalBroadcastManager localBroadcastManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
        Button button = findViewById(R.id.sendButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("fuckoff");
                intent.setComponent(new ComponentName("com.example.forceoffline","com.example.forceoffline.MyReceiver"));
                sendBroadcast (intent);
            }
        });
    }
}