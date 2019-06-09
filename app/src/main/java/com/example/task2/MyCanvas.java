package com.example.task2;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.MotionEvent;

import java.lang.reflect.Array;

import static android.view.MotionEvent.*;

public class MyCanvas extends View {
    Paint paintRect, paintCircle, paintToken, canvasPaint;
    Path pathRect;
    Bitmap canvasBitmap;
    Canvas drawCanvas;
    int height;
    int width;
    int count = 0;
    int x = 0;
    int y = 0;
    boolean touched;
    float tokenX = 90, tokenY = 90;
    int arrX[][] = new int[6][7];
    int arrY[][] = new int[6][7];
    Pair<int[][], int[][]> cood = new Pair<int[][], int[][]>(arrX, arrY);
    private static final String TAG = "message";


    public MyCanvas(Context context, AttributeSet attrs, int screenHeight, int screenWidth) {
        super(context, attrs);
        //space for token
        paintCircle = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintCircle.setStyle(Paint.Style.FILL_AND_STROKE);
        paintCircle.setStrokeWidth(5f);
        paintCircle.setColor(Color.WHITE);
        //grid border
        pathRect = new Path();
        //grid
        paintRect = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintRect.setStyle(Paint.Style.FILL);
        paintRect.setColor(Color.BLUE);
        paintRect.setStyle(Paint.Style.FILL_AND_STROKE);
        //tokens
        paintToken = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintToken.setStyle(Paint.Style.FILL);
        paintToken.setColor(Color.GREEN);

        canvasPaint = new Paint();
        height = screenHeight;
        width = screenWidth;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        touched = true;
        //getting the touched x and y position
        float xPos = event.getX();
        float yPos = event.getY();
        switch (event.getAction()) {
            case ACTION_DOWN:
                break;

            case ACTION_MOVE:
                break;
            case ACTION_UP:
                tokenX = xPos;
                tokenY = yPos;
                invalidate();
                break;
            default:
                return true;

        }

        return false;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //outline for grid
        int padding = 30;
        int gridTop = height / 3;
        int gridBottom = height - padding;
        int gridLeft = padding;
        int gridRight = width - padding;
        int totalHeight = gridBottom - gridTop;
        int totalWidth = gridRight - gridLeft;
        int colSpacing = 15;
        int colWidth = (totalWidth - 8 * colSpacing) / 7;
        int rowSpacing = (totalHeight - 7 * colWidth) / 6;
        int radius = colWidth / 3;
        int n = 0, m = 1, x;
        int circleY, circleX;
        int circX;
        int changeCol = 0;
        int xPos = 1000, yPos = 1080;

        Log.e(TAG, "Right" + String.valueOf(gridRight));
        Log.e(TAG, "Left" + String.valueOf(gridLeft));
        Log.e(TAG, "Top" + String.valueOf(gridTop));
        Log.e(TAG, "Bottom" + String.valueOf(gridBottom));

        // bg colour
        canvas.drawColor(Color.MAGENTA);
        //draw grid
        canvas.drawRect(gridLeft, gridTop, gridRight, gridBottom, paintRect);
        //draw circles
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                while (n <= 6) {
                    for (m = 0; m < 6; m++) {
                        circleX = gridLeft + colSpacing + radius + n * (colWidth + colSpacing);
                        circleY = gridBottom - colSpacing - radius - m * (colWidth + rowSpacing);
                        canvas.drawCircle(circleX, circleY, radius, paintCircle);
                        {
                            arrX[i][j] = circleX;
                            arrY[i][j] = circleY;
                        }
                        ;
                        n++;
                    }
                }
            }


            if (touched) {
                if (1 == changeCol % 2) {
                    paintCircle.setColor(Color.BLUE);
                } else {
                    paintCircle.setColor(Color.GREEN);
                }
                circX = 10;
                for (n = 1; n <= 6; n++)
                    circX = gridLeft + colSpacing + colWidth + n * (colWidth + colSpacing);
                if (xPos < circX) {
                    canvas.drawCircle(circX, gridTop + radius, radius, paintCircle);
                    changeCol++;
                    count++;
                    invalidate();
                }
            }

        }
        while (count != 0) {
            for (int i = 0; i <= 7; i++) {
                for (int j = 0; j <= 6; j++) {
                    x = cood.first[i][j];
                    y = cood.second[i][j];
                    canvas.drawCircle(x, y, radius, paintCircle);
                }

            }
            count--;
        }
    }
}


