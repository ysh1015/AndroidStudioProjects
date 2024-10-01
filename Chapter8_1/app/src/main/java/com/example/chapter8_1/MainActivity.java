package com.example.chapter8_1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnRead, btnWrite;
        btnRead = (Button) findViewById(R.id.btnRead);
        btnWrite = (Button) findViewById(R.id.btnWrite);

        btnWrite.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    FileOutputStream outFs = openFileOutput("file.txt",
                            Context.MODE_PRIVATE);
                    String str = "쿡북 안드로이드";
                    outFs.write(str.getBytes()); // 위에 있는게 왼쪽, 밑에 있는게 오른쪽 메서드 안에
                    // outputstream이면 write
                    outFs.close();
                    Toast.makeText(getApplicationContext(), "file.txt가 생성됨", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                }
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    FileInputStream inFs = openFileInput("file.txt");
                    byte[] txt = new byte[30];
                    inFs.read(txt); // inFs.read(txt) 빈칸
                    // inputstream이면 read
                    String str = new String(txt); // new 빈칸
                    Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                    // Toast자리 빈칸
                    inFs.close();
                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "파일 없음" , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
