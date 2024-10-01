package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //변수의 입력 공간(필드)
    Button btnMan; // ID와 이름 똑같이 변수명을 만든다
    Button btnWoman;
    TextView textView;
    LinearLayout layoutColor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //입력한 변수와 리소스를 연결하는 부분 (findViewById함수로 xml에서 가져온다.)
        btnMan = (Button)findViewById(R.id.btnMan);
        btnWoman = (Button)findViewById(R.id.btnWoman);
        textView = (TextView)findViewById(R.id.textView);
        layoutColor = (LinearLayout)findViewById(R.id.layoutColor);


        //이벤트를 연결해요
        // 안드로이드는 2가지 방법 - listener이용, clickEvent이용(늘리는게 안돼서 터치리스너를 씀)
        btnMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 잠깐 떴다가 사라지는 기능
                Toast.makeText(MainActivity.this, "남자네요", Toast.LENGTH_SHORT).show();

                textView.setTextSize(30);
                textView.setText("남자를 눌렀군요!!");
                textView.setTextColor(Color.WHITE);
                layoutColor.setBackgroundColor(Color.BLUE);

            }
        });

        btnWoman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 잠깐 떴다가 사라지는 기능
                Toast.makeText(MainActivity.this, "여자네요", Toast.LENGTH_SHORT).show();

                textView.setTextSize(50);
                textView.setText("여자를 눌렀군요!!");
                textView.setTextColor(Color.WHITE);
                layoutColor.setBackgroundColor(Color.RED);
            }
        });
    }
}