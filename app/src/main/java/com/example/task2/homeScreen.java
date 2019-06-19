package com.example.task2;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.*;
import android.view.Display;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.WindowManager;

import static java.lang.Boolean.TRUE;

public class homeScreen extends AppCompatActivity {
    private static final String TAG = "message";
    MyCanvas myCanvas;
    Point size = new Point();
    boolean undoPress;
    //create the undo button in the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_undo, menu);
        return super.onCreateOptionsMenu(menu);
    }
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
        myCanvas = new MyCanvas(this, null, size.y, size.x, p1Col, p2Col, undoPress);
        setContentView(myCanvas);
        Log.e(TAG, "height" + String.valueOf(size.y));
        Log.e(TAG, "width" + String.valueOf(size.x));
        }

    // handle button activities
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.undoBtn) {
            undoPress = TRUE;
        }
        return super.onOptionsItemSelected(item);
    }
    }




