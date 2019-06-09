package com.example.task2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.graphics.*;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_MOVE;
import static android.view.MotionEvent.ACTION_UP;
import static java.lang.Boolean.TRUE;
import android.util.Log;
import android.view.WindowManager;

public class homeScreen extends AppCompatActivity {
    private static final String TAG = "message";
    MyCanvas myCanvas;
    Point size = new Point();
    int x,y;
    boolean touched;
    float tokenX=90, tokenY=90;
    Canvas drawCanvas;
    Paint canvasPaint;
    int padding = 30;
    int gridTop = y / 3;
    int gridBottom = y - padding;
    int gridLeft = padding;
    int gridRight = x - padding;
    int totalHeight = gridBottom - gridTop;
    int totalWidth = gridRight - gridLeft;
    int colSpacing = 15;
    int colWidth = (totalWidth - 8 * colSpacing) / 7;
    int rowSpacing = (totalHeight - 7 * colWidth) / 6;
    int radius = colWidth / 3;
    int n = 0, m = 1;
    int circleY, circleX;
    int arrX[][] = new int[6][7];
    int arrY[][] = new int[6][7];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //getting data: playerNumber, colours
        Intent intename = getIntent();
        final int playerNum = (int) intename.getIntExtra("mode", 0);
        final int p1Col = intename.getIntExtra("col1", 0);
        final int p2Col = intename.getIntExtra("col2", 0);


        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        display.getSize(size);
        x = size.x;
        y = size.y;
        myCanvas = new MyCanvas(this, null, size.y, size.x);
        setContentView(new MyCanvas(this, null, size.y, size.x));
        Log.e(TAG, "height" + String.valueOf(size.y));
        Log.e(TAG, "width" + String.valueOf(size.x));

    }
}



