package com.example.task2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class PlayerNumber extends AppCompatActivity {
    int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_number);

            Button singleButton = (Button) findViewById(R.id.singleplayer);
            Button twoButton = (Button) findViewById(R.id.twoplayer);
            final Button nextButton = (Button) findViewById(R.id.next);
            //single player mode

            singleButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    mode = 1;
                    nextButton.setVisibility(v.VISIBLE);
                }
            });
            // two players mode
            twoButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    mode = 2;
                    nextButton.setVisibility(v.VISIBLE);
                }
            });
            //next button
            nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent settingIntent2 = new Intent(PlayerNumber.this, PlayerColour.class);
                    settingIntent2.putExtra("player", mode);
                    startActivity(settingIntent2);
                }
            });
        }
    }
