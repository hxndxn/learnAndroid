package com.example.forceoffline;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    public static final String ACCOUNT="admin";
    public static final String PASSWORD="123456";
    private EditText mAccountEditText;
    private EditText mPasswordEditText;
    private CheckBox mCheckBox;
    private SharedPreferences mSharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAccountEditText = findViewById(R.id.accountEditText);
        mPasswordEditText = findViewById(R.id.passwordEditText);
        mCheckBox = findViewById(R.id.remember);
        mSharedPreferences = getPreferences(MODE_PRIVATE);
        ((Button)findViewById(R.id.loginButton)).setOnClickListener(this);
        Boolean remembered = mSharedPreferences.getBoolean("remember", false);
        if(remembered){
            mAccountEditText.setText(mSharedPreferences.getString("account",""));
            mPasswordEditText.setText(mSharedPreferences.getString("password",""));
            mCheckBox.setChecked(true);
        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId() ==R.id.loginButton){
            String account = mAccountEditText.getText().toString();
            String password = mPasswordEditText.getText().toString();
            boolean toRemember = mCheckBox.isChecked();
            if(account.equals(ACCOUNT)&&password.equals(PASSWORD)){
                mSharedPreferences.edit()
                    .putString("account",account)
                    .putString("password",password)
                    .putBoolean("remember",toRemember)
                    .apply();
                Intent intent = new Intent(this,BroadcastActivity.class);
                startActivity(intent);
            }
            else{
                Toast.makeText(this,"登陆失败",Toast.LENGTH_SHORT).show();
            }
        }
    }
}