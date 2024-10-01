package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2;
    TextView tv;
    Button btnPlus, btnMinus, btnMul, btnDiv;

    String num1, num2;
    Double result;
    Button[] numButtons =  new Button[10];
    // 인덱스 값
    int[] numButtonsIds = {R.id.btnNum0, R.id.btnNum1, R.id.btnNum2,R.id.btnNum3
            ,R.id.btnNum4,R.id.btnNum5,R.id.btnNum6,R.id.btnNum7,R.id.btnNum8
            ,R.id.btnNum9};
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);

        tv = (TextView) findViewById(R.id.tv);

        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnDiv = (Button) findViewById(R.id.btnDiv);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = et1.getText().toString();
                num2 = et2.getText().toString();

                result = Double.parseDouble(num1) + Double.parseDouble(num2);
                tv.setText("덧셈 결과 : " + result.toString());
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = et1.getText().toString();
                num2 = et2.getText().toString();

                result = Double.parseDouble(num1) - Double.parseDouble(num2);
                tv.setText("뺄셈 결과 : " + result.toString());
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = et1.getText().toString();
                num2 = et2.getText().toString();

                result = Double.parseDouble(num1) * Double.parseDouble(num2);
                tv.setText("곱셈 결과 : " + result.toString());
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = et1.getText().toString();
                num2 = et2.getText().toString();

                result = Double.parseDouble(num1) / Double.parseDouble(num2);
                tv.setText("나눗셈 결과 : " + result.toString());
            }
        });

        // 숫자 버튼 10개를 대입
        for(i = 0; i < numButtonsIds.length; i++){
            numButtons[i] = (Button)findViewById(numButtonsIds[i]);
        }
        // 숫자 버튼 10개에 대해서 클릭이벤트 처리
        for(i = 0; i < numButtonsIds.length; i++){
            int tmp;
            tmp = i;
            numButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(et1.isFocused() == true){
                        //num1 = et1.getText().toString() + et2.getText().toString();
                        //et1.setText(num1);
                        et1.setText(et1.getText().toString() + numButtons[tmp].getText().toString());
                    }
                    else if(et2.isFocused() == true){
                        et2.setText(et2.getText().toString() + numButtons[tmp].getText().toString());
                    }
                    else {
                        Toast.makeText(MainActivity.this, "포커스를 입력창으로", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}