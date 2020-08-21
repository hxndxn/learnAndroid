package com.example.ActivityTest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "SecondActivity";
    private void backWithResult(){
        Intent intent = new Intent();
        intent.putExtra("resultData","hello, 1st act, here is 2nd act");
        setResult(RESULT_OK,intent);
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: taskID is"+getTaskId());
        Log.d(TAG, "onCreate: "+this.toString());
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        //Toast.makeText(SecondActivity.this,intent.getStringExtra("msg"),Toast.LENGTH_LONG).show();
        Button button = (Button)findViewById(R.id.second_button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //backWithResult();
                startActivity(new Intent(SecondActivity.this,ThirdActivity.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        backWithResult();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}