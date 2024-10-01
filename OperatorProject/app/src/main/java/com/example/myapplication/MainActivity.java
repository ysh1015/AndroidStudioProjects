package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    EditText et2;
    Button btnAdd;
    Button btnMinus;
    Button btnMul;
    Button btnDiv;
    TextView tv;
    String su1, su2;
    Integer result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //밑에 생성자 보고 onCreate 빈칸 쓰기
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.et1);
        et2 = (EditText)findViewById(R.id.et2);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnMinus = (Button)findViewById(R.id.btnMinus);
        btnMul = (Button)findViewById(R.id.btnMul);
        btnDiv = (Button)findViewById(R.id.btnDiv);
        tv = (TextView)findViewById(R.id.tv);
        
        //show(), dialog() => 보여주는 함수
        //Toast show

        //변수는 객체로 바뀐다(객체지향 언어)
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get 입력의 의미 , set 출력의 의미
                //toSTring() ==> 시험문제
                //글자인지를 판단
                su1 = et1.getText().toString();
                su2 = et2.getText().toString();
                //Integer자리 빈칸  ==> 시험문제
                result = Integer.parseInt(su1) + Integer.parseInt(su2);
                tv.setText("결과 :" + result.toString());
                //클릭 리스너는 리턴 안써도 됨
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                su1 = et1.getText().toString();
                su2 = et2.getText().toString();
                result = Integer.parseInt(su1) - Integer.parseInt(su2);
                tv.setText("결과 :" + result.toString());
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                su1 = et1.getText().toString();
                su2 = et2.getText().toString();
                result = Integer.parseInt(su1) * Integer.parseInt(su2);
                tv.setText("결과 :" + result.toString());
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                su1 = et1.getText().toString();
                su2 = et2.getText().toString();
                result = Integer.parseInt(su1) / Integer.parseInt(su2);
                tv.setText("결과 :" + result.toString());
            }
        });
        
    }
}