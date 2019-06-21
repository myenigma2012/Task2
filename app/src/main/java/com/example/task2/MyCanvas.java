package com.example.task2;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.MotionEvent;

import java.util.ArrayList;

import static android.view.MotionEvent.*;
import static java.lang.Boolean.TRUE;

public class MyCanvas extends View {
    Paint paintRect, paintCircle;
    Token drawToken;
    int height;
    int width;
    int p1Col, p2Col;
    int count = 0;
    boolean touched, undoPress;
    float tokenX = 90, tokenY = 90;
    private static final String TAG = "message";
    ArrayList<Integer> lastColoumn = new ArrayList<Integer>();
    ArrayList<Integer> lastRow = new ArrayList<Integer>();
    public MyCanvas(Context context, AttributeSet attrs, int screenHeight, int screenWidth, int player1Col, int player2Col, boolean undo) {
        super(context, attrs);
        //space for token
        paintCircle = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintCircle.setStyle(Paint.Style.FILL_AND_STROKE);
        paintCircle.setStrokeWidth(5f);
        paintCircle.setColor(Color.WHITE);
        //grid
        paintRect = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintRect.setColor(Color.BLUE);
        paintRect.setStyle(Paint.Style.FILL_AND_STROKE);

        height = screenHeight;
        width = screenWidth;
        drawToken = new Token();
        p1Col = player1Col;
        p2Col = player2Col;
        undoPress = undo;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        touched = true;
        //different screens have diff. sizes and we have to take care. canvas wookes on pix, others wokr on dp,sp.
        //getting the touched x and y position
        float xPos = event.getX();
        float yPos = event.getY();
        tokenX = xPos;
        tokenY = yPos;
        invalidate();
        return false;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //outline for grid
        int padding = 30;
        int gridTop = height / 3;
        int gridBottom = height - 7 * padding;
        int gridLeft = padding;
        int gridRight = width - padding;
        int totalHeight = gridBottom - gridTop;
        int totalWidth = gridRight - gridLeft;
        int colSpacing = 15;
        int colWidth = (totalWidth - 8 * colSpacing) / 7;
        int rowSpacing = (totalHeight - 7 * colWidth) / 6;
        int radius = colWidth / 3;
        int n, i;
        int row=0;
        int circleY, circleX;
        int circX;
        int pCol = 1;


        Log.e(TAG, "Right" + String.valueOf(gridRight));
        Log.e(TAG, "Left" + String.valueOf(gridLeft));

        // bg colour
        canvas.drawColor(Color.MAGENTA);
        //draw grid
        canvas.drawRect(gridLeft, gridTop, gridRight, gridBottom, paintRect);
        //draw circles
        for (i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                //assigning colour to the matrix value so that it can be printed
                circleX = gridLeft + colSpacing + radius + j * (colWidth + colSpacing);
                circleY = gridBottom - colSpacing - radius - i * (colWidth + rowSpacing);

                if (drawToken.getValue(i, j) == 1) {
                    paintCircle.setColor(p1Col);
                    //animate the circle
                    if( i == lastRow.get( lastRow.size()-1) && j== lastColoumn.get( lastColoumn.size()-1)){
                        canvas.drawCircle(circleX, gridTop-4*radius, radius, paintCircle);
                        canvas.translate(0, circleY-gridTop-4*radius );
                    }
                    else {
                        canvas.drawCircle(circleX, circleY, radius, paintCircle);
                    }
                } else if (drawToken.getValue(i, j) == 2) {
                    paintCircle.setColor(p2Col);
                    if( i == lastRow.get( lastRow.size()-1) && j== lastColoumn.get( lastColoumn.size()-1)) {
                        canvas.drawCircle(circleX, gridTop-4*radius, radius, paintCircle);
                        canvas.translate(0, circleY-gridTop-4*radius );
                    }
                    else{
                        canvas.drawCircle(circleX, circleY, radius, paintCircle);
                    }
                } else {
                    paintCircle.setColor(Color.WHITE);
                    canvas.drawCircle(circleX, circleY, radius, paintCircle);
                }

            }
        }

        if (touched) {
            count++;
            if (count % 2 == 0) {
                pCol = 2;
            } else {
                pCol = 1;
            }
            for (n = 0; n < 7; n++) {
                circX = gridLeft + colSpacing + colWidth + n * (colWidth + colSpacing);
                if (tokenX < circX) {
                    //the matrix should hold an int the position of the token
                    row = drawToken.setTokenColour(n, pCol);
                    // the undo button should be able to undo the value of the token in the matrix to 0
                    lastRow.add(row);
                    lastColoumn.add(n);
                    // loop should stop when if becomes true for the first time
                    break;
                }
            }
        }
            //the undo button
            if (undoPress == TRUE){
                drawToken.undoBtn( lastRow.get(lastRow.size() -1), lastColoumn.get(lastColoumn.size()-1) );
                // to change the player
                count -= 1;
            }
        }
    }

