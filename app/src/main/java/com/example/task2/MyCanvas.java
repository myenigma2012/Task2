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
import static android.view.MotionEvent.*;

public class MyCanvas extends View {
    Paint paintRect, paintCircle;
    Token drawToken;
    int height;
    int width;
    int count = 0;
    int x = 0;
    int y = 0;
    boolean touched;
    float tokenX = 90, tokenY = 90;
    private static final String TAG = "message";
    Pair<Integer, Integer>[] coord = new Pair[42];


    public MyCanvas(Context context, AttributeSet attrs, int screenHeight, int screenWidth) {
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
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        touched = true;
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
        int gridBottom = height -7* padding;
        int gridLeft = padding;
        int gridRight = width - padding;
        int totalHeight = gridBottom - gridTop;
        int totalWidth = gridRight - gridLeft;
        int colSpacing = 15;
        int colWidth = (totalWidth - 8 * colSpacing) / 7;
        int rowSpacing = (totalHeight - 7 * colWidth) / 6;
        int radius = colWidth / 3;
        int n, i;
        int circleY, circleX;
        int circX, circY;
        int pCol = 1;


        Log.e(TAG, "Right" + String.valueOf(gridRight));
        Log.e(TAG, "Left" + String.valueOf(gridLeft));
        Log.e(TAG, "Top" + String.valueOf(gridTop));
        Log.e(TAG, "Bottom" + String.valueOf(gridBottom));

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
                    paintCircle.setColor(Color.GREEN);
                    canvas.drawCircle(circleX, circleY, radius, paintCircle);
                } else if (drawToken.getValue(i, j) == 2) {
                    paintCircle.setColor(Color.RED);
                    canvas.drawCircle(circleX, circleY, radius, paintCircle);
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
                if( //undo button is clicked//
                ){
                    undoClick = 1;
                }

                for (n = 0; n < 7; n++) {
                    circX = gridLeft + colSpacing + colWidth + n * (colWidth + colSpacing);
                    if (tokenX < circX) {
                        //the matrix should hold a 1 int the position of the token
                        drawToken.setTokenColour(n , pCol, undoClick);
                        if ( /*(button onClickListener==TRUE))*/)
                            drawToken.undoBtn( n-1);
                            paintCircle.setColor(Color.WHITE);
                            circY= gridBottom - colSpacing - radius - m * (colWidth + rowSpacing);
                        { canvas.drawCircle( circX, circY, radius, paintCircle );}
                        count--;
                        if (count % 2 == 0) {
                            pCol = 2;
                        } else {
                            pCol = 1;
                        }
                    }
                }
            }


        }
    }

    