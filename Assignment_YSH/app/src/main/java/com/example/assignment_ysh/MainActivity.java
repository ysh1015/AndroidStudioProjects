package com.example.assignment_ysh;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText edtAngle;
    private ImageView imageView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("제주도 풍경");

        edtAngle = findViewById(R.id.edtAngle);
        imageView1 = findViewById(R.id.imageView1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.itemRotate) {
            float angle = Float.parseFloat(edtAngle.getText().toString());
            imageView1.setRotation(angle);
            return true;
        } else if (itemId == R.id.item1) {
            imageView1.setImageResource(R.drawable.jeju2);
            return true;
        } else if (itemId == R.id.item2) {
            imageView1.setImageResource(R.drawable.jeju14);
            return true;
        } else if (itemId == R.id.item3) {
            imageView1.setImageResource(R.drawable.jeju6);
            return true;
        } else {
            
            return false;
        }
    }
}