package com.example.intent3;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("암시적 인텐트 예제");

        Button btnDial = (Button) findViewById(R.id.btnDial);
        Button btnWeb = (Button) findViewById(R.id.btnWeb);
        Button btnGoogle = (Button) findViewById(R.id.btnGoogle);
        Button btnSearch = (Button) findViewById(R.id.btnSearch);
        Button btnSms = (Button) findViewById(R.id.btnSms);
        Button btnPhoto = (Button) findViewById(R.id.btnPhoto);

        btnDial.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:010-2529-2924");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
            }
        });

        btnWeb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.hknu.ac.kr");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        btnGoogle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri uri = Uri.parse("https://maps.google.co.kr/maps?q=" // Uri.pase에서 Uri빈칸
                        + 37.559133 + "," + 126.927824 + "&z=15");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, "안드로이드");
                startActivity(intent);
            }
        });

        btnSms.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                for(int i = 0; i < 5; i++) {
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.putExtra("sms_body", "키득");
                    intent.setData(Uri.parse("smsto:" + Uri.encode("010-1234-4567")));
                    startActivity(intent);
                }
            }
        });

        btnPhoto.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore. ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });
    }

}

