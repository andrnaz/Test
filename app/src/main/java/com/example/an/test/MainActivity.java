package com.example.an.test;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnTouchListener {

    TextView tv;
    float x;
    float y;
    String sDown;
    String sMove;
    String sUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawView(this));

        tv = new TextView(this);
        tv.setOnTouchListener(this);
        setContentView(tv);



    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        x = event.getX();
        y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: // нажатие
                sDown = "Down: " + x + "," + y;
                sMove = ""; sUp = "";
                break;
            case MotionEvent.ACTION_MOVE: // движение
                sMove = "Move: " + x + "," + y;
                break;
            case MotionEvent.ACTION_UP: // отпускание
            case MotionEvent.ACTION_CANCEL:
                sMove = "";
                sUp = "Up: " + x + "," + y;
                break;
        }
        tv.setText(sDown + "\n" + sMove + "\n" + sUp);
        return true;
    }




    class DrawView extends View {

        Paint p;
        Rect rect;

        public DrawView(Context context) {
            super(context);
            p = new Paint();
            rect = new Rect();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            // заливка канвы цветом
            canvas.drawARGB(80, 102, 204, 255);

            // настройка кисти
            // красный цвет
            p.setColor(Color.RED);
            // толщина линии = 10
            p.setStrokeWidth(10);

            // рисуем точку (50,50)
            canvas.drawPoint(50, 50, p);

/*            // рисуем линию от (100,100) до (500,50)
            canvas.drawLine(100,100,500,50,p);

            // рисуем круг с центром в (100,200), радиус = 50
            canvas.drawCircle(100, 200, 50, p);

            // рисуем прямоугольник
            // левая верхняя точка (200,150), нижняя правая (400,200)
            canvas.drawRect(200, 150, 400, 200, p);

            // настройка объекта Rect
            // левая верхняя точка (250,300), нижняя правая (350,500)
            rect.set(250, 300, 350, 500);
            // рисуем прямоугольник из объекта rect
            canvas.drawRect(rect, p);*/
        }

    }

}