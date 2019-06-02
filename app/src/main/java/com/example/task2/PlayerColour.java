package com.example.task2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PlayerColour extends AppCompatActivity {

    View view;
    String p2colour ;
    String p1colour;
    int n =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_colour);

    final Button whiteBtn =(Button) findViewById(R.id.wBtn);
    final Button greenBtn =(Button) findViewById(R.id.gBtn);
    final Button blueBtn =(Button) findViewById(R.id.bBtn);
    final Button redBtn =(Button) findViewById(R.id.rBtn);
    final Button playBtn = (Button) findViewById(R.id.playBtn);
    final TextView name = (TextView) findViewById(R.id.name);

        playBtn.setVisibility(View.GONE);

         whiteBtn.setOnClickListener(new View.OnClickListener(){
             public void onClick (View v){
                if (n == 1){
                     p1colour = "white";
                }
                else {
                     p2colour = "white";
                }
                n++;
                 name.setText("Player 2");
                whiteBtn.setVisibility(v.INVISIBLE);
                 if (n>2){
                     playBtn.setVisibility(View.VISIBLE);
                     redBtn.setVisibility(View.INVISIBLE);
                     greenBtn.setVisibility(View.INVISIBLE);
                     blueBtn.setVisibility(View.INVISIBLE);
                 }
            }
        });
        blueBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                if (n == 1){
                     p1colour = "blue";
                }
                else {
                     p2colour = "blue";
                }
                n++;
                name.setText("Player 2");
                blueBtn.setVisibility(v.INVISIBLE);
                if (n>2){
                    playBtn.setVisibility(View.VISIBLE);
                    whiteBtn.setVisibility(View.INVISIBLE);
                    greenBtn.setVisibility(View.INVISIBLE);
                    redBtn.setVisibility(View.INVISIBLE);
                }
            }
        });
        greenBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                if (n == 1){
                    p1colour = "green";
                }
                else {
                    p2colour = "green";
                }
                n++;
                name.setText("Player 2");
                greenBtn.setVisibility(v.INVISIBLE);
                if (n>2){
                    playBtn.setVisibility(View.VISIBLE);
                    whiteBtn.setVisibility(View.INVISIBLE);
                    redBtn.setVisibility(View.INVISIBLE);
                    blueBtn.setVisibility(View.INVISIBLE);
                }
            }
        });

        redBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                if (n == 1){
                    p1colour = "red";
                }
                else {
                    p2colour = "red";
                }
                n++;
                name.setText("Player 2");
                redBtn.setVisibility(v.INVISIBLE);
                if (n>2){
                    playBtn.setVisibility(View.VISIBLE);
                    whiteBtn.setVisibility(View.INVISIBLE);
                    greenBtn.setVisibility(View.INVISIBLE);
                    blueBtn.setVisibility(View.INVISIBLE);
                }
            }
        });
        playBtn.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ( PlayerColour.this, homeScreen.class);
                intent.putExtra( "col1", p1colour);
                intent.putExtra( "col2", p2colour);
                startActivity(intent);
            }
        });


    }

}

