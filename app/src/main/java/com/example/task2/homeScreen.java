package com.example.task2;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.*;
import android.view.Display;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Button;

public class homeScreen extends AppCompatActivity {
    private static final String TAG = "message";
    MyCanvas myCanvas;
    Point size = new Point();


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
        myCanvas = new MyCanvas(this, null, size.y, size.x);
        setContentView(new MyCanvas(this, null, size.y, size.x));
        Log.e(TAG, "height" + String.valueOf(size.y));
        Log.e(TAG, "width" + String.valueOf(size.x));



    }
}



