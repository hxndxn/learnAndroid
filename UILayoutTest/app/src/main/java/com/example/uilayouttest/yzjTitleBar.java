package com.example.uilayouttest;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class yzjTitleBar extends LinearLayout {
    public yzjTitleBar(final Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.my_title_bar,this);
        ((Button)findViewById(R.id.title_back)).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ((Activity)context).finish();
            }
        });
    }
}
