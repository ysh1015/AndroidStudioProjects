package com.example.graphicandimage;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    final static int LINE = 1, CIRCLE = 2;
    static int curShape = CIRCLE;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
        setTitle("간단 그림판");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, 1, 0, "선 그리기");
        menu.add(0, 2, 0, "원 그리기");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
//        switch (itemId) {
//            case 1:
//                curShape = LINE; // 선
//                return true;
//            case 2:
//                curShape = CIRCLE; // 원
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
        if (itemId == 1) {
            curShape = LINE; // 선
            return true;
        } else if (itemId == 2) {
            curShape = CIRCLE; // 원
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private static class MyGraphicView extends View {
        int startX = -1, startY = -1, stopX = -1, stopY = -1;
        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            int action = event.getAction();
            if (action == MotionEvent.ACTION_DOWN) {
                startX = (int) event.getX();
                startY = (int) event.getY();
            } else if (action == MotionEvent.ACTION_MOVE || action == MotionEvent.ACTION_UP) {
                stopX = (int) event.getX();
                stopY = (int) event.getY();
                this.invalidate();
                // invalidate() - 화면 갱신
            }
            return true;
        }
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStrokeWidth(5);
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(Color.RED);

            if (curShape == LINE) {
                canvas.drawLine(startX, startY, stopX, stopY, paint);
            } else if (curShape == CIRCLE) {
                int radius = (int) Math.sqrt(Math.pow(stopX - startX, 2)
                        + Math.pow(stopY - startY, 2));
                canvas.drawCircle(startX, startY, radius, paint);
            }
        }
    }
}

