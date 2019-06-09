import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.MotionEvent;

public class MyCanvas extends View {
    Paint paint, paintRect, paintCircle;
    Path path, pathRect;
    //outline for grid
    int padding = 20;
    int gridTop = getHeight() / 2;
    int gridBottom = getHeight() - padding;
    int gridLeft = padding;
    int gridRight = getWidth() - padding;
    int totalHeight = gridBottom - gridTop;
    int totalWidth = gridRight - gridLeft;
    int colSpacing = 15;
    int colWidth = (totalWidth - 8 * colSpacing) / 7;
    int rowSpacing = (totalHeight - 6 * colWidth) / 7;
    int radius = colWidth / 2;
    int n, m, x;
    int circleX = gridLeft + colSpacing + radius + n * (colWidth + colSpacing);
    int circleY = gridBottom - rowSpacing - radius - m * (colWidth + rowSpacing);
    int y = gridTop + rowSpacing;
    int arrX[][] = new int[6][7];
    int arrY[][] = new int[6][7];


    public MyCanvas(Context context, AttributeSet attrs) {
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

        //assigning coordinates of circles to the array
        n = 0;
        m = 1;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (n < 7) {
                    arrX[i][j] = circleX;
                }
                if (m < 6) {
                    arrY[i][j] = circleY;
                }
                n++;
                m++;
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float xPos = event.getX();
        float yPos = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                for (n = 0; n < 7; n++)
                    if (xPos < circleX)
                        x = circleX;
                break;
            default:
                return false;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //bg colour
        canvas.drawColor(Color.MAGENTA);
        //draw circles
        while (n <= 6) {
            for (int m = 1; m <= 6; m++) {
                canvas.drawCircle(circleX, circleY, radius, paintCircle);
            }
            n++;
        }
        //draw grid
        canvas.drawRect(gridLeft, gridTop, gridRight, gridBottom, paintRect);

            canvas.drawCircle( x,y, radius, paintCircle);
    }




}
