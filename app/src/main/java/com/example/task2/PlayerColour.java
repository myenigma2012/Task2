package com.example.task2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PlayerColour extends AppCompatActivity implements View.OnClickListener {

    String p2colour ;
    String p1colour;
    int n =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_colour);
    }
     Button whiteBtn =(Button) findViewById(R.id.wBtn);
    Button greenBtn =(Button) findViewById(R.id.gBtn);
    Button blueBtn =(Button) findViewById(R.id.bBtn);
    Button redBtn =(Button) findViewById(R.id.rBtn);
    Button playBtn = (Button) findViewById(R.id.playBtn);
    TextView name = (TextView) findViewById(R.id.name);



public void playerName(){
                    name.setText("Player 2");
                    }

    @Override
    public void onClick(View v) {
         whiteBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                if (n == 1){
                     p1colour = "white";
                }
                else {
                     p2colour = "white";
                }
                n++;
                playerName();
                whiteBtn.setVisibility(v.INVISIBLE);
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
                playerName();
                blueBtn.setVisibility(v.INVISIBLE);
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
                playerName();
                greenBtn.setVisibility(v.INVISIBLE);
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
                playerName();
                redBtn.setVisibility(v.INVISIBLE);
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


        if (p2colour !=  "") {
        playBtn.setVisibility(v.VISIBLE);
        }
    }

}

