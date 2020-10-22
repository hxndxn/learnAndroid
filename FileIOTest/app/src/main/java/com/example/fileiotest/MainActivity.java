package com.example.fileiotest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class MainActivity extends AppCompatActivity {
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.edit_text);
        load(et);
        findViewById(R.id.button).setOnClickListener(view -> MainActivity.this.finish());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        save(et);
    }

    private void save(EditText et){
        Writer writer = null;
        try{
            OutputStream out = openFileOutput("data",MODE_PRIVATE);
            writer = new OutputStreamWriter(out);
            writer.write(et.getText().toString());
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(writer!=null){
                try{
                    writer.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

    }
    private void  load(EditText et){
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();
        try{
            InputStream in = openFileInput("data");
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while((line = reader.readLine())!=null){
                content.append(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(reader != null){
                try{
                    reader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        et.setText(content.toString());
    }
}
