package com.example.task2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.graphics.*;
import android.view.View;
import static java.lang.Boolean.TRUE;
import android.util.Log;

public class homeScreen extends AppCompatActivity {
    private static final String TAG = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
        Log.i(TAG, "onCreate");
    }
    public class MyView extends View {

        Paint paintCircle, paintRect;
        Path pathRect;

        public MyView(Context context) {
            super(context);
            init();
        }

        private void init() {
            //space for tokens
            paintCircle = new Paint(Paint.ANTI_ALIAS_FLAG);
            paintCircle.setStrokeWidth(20);
            paintCircle.setColor(Color.WHITE);
            //grid
            paintRect = new Paint(Paint.ANTI_ALIAS_FLAG);
            paintRect.setStyle(Paint.Style.FILL);
            paintRect.setColor(Color.BLUE);
            //outline for grid
            pathRect = new Path();
        }
        int mPadding = 20;
        int gridTop = getHeight()/2;
        int gridBottom = getHeight() - mPadding;
        int gridLeft= mPadding;
        int gridRight = getWidth() - mPadding;
        int totalHeight= gridBottom - gridTop;
        int totalWidth = gridRight - gridLeft;
        int colSpacing = 7;
        int colWidth= (totalWidth -8*colSpacing)/7;
        int rowSpacing = (totalHeight - 6*colWidth)/7;
        int radius = colWidth/2;
        int n=0, i =1;
        int circleX = gridLeft + colSpacing + radius +n*(colWidth + colSpacing);
        int circleY = gridBottom -rowSpacing-radius -i*(2*radius +rowSpacing);
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);




            //bg colour
            canvas.drawColor(Color.MAGENTA);
            //draw grid
            canvas.drawRect(gridLeft, gridTop, gridRight, gridBottom, paintRect);

            //draw circles
            while(n<=6){
                for (i=1 ; i<=6; i++){
                    canvas.drawCircle( circleX, circleY, radius, paintCircle);
                    i=1;
                }
            }
        }
    }
}

