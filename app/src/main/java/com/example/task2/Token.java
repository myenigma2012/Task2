package com.example.task2;

import android.util.Log;

public class Token {
    int[][] token = new int[6][7];
    int [] row= {5,5,5,5,5,5,5};
    int sum=0;
    int x=0;
    public static final String TAG = "message" ;
    public void setTokenColour ( int coloumn, int colour){
        int y = row[coloumn];
        Log.e(TAG, String.valueOf(y));
        token[y][coloumn]= colour;
        row[coloumn]= y--;
        Log.e(TAG, String.valueOf(y));

    }
    public int gameEnd( int playerNum){
                return playerNum;
    }

    public int getValue ( int i, int j ){
        int x= token[i][j];
        return x;
    }

    public void undoBtn(  int coloumn, int undoClick) {
        row[coloumn] +=1;
        int y=row[coloumn];
        token [y][coloumn]=0;

    }

    public  void main(String[] args) {
        Token value = new Token();
        //to see if game ended in any row.
        for (int i = 0; i < 6; i++) {
            for (int n = 0; n < 3; n++) {
                for (int j = n; j < n + 4; j++) {
                    x = value.getValue(i, j);
                    sum = sum + x;
                    if (sum == 4) {
                        value.gameEnd(1);
                    } else if (sum == 8) {
                        value.gameEnd(2);
                    }
                    if (sum == 12) {
                        value.gameEnd(3);
                    } else if (sum == 16) {
                        value.gameEnd(4);
                    }
                }
            }
        }
        //to check if game ended in any coloumn
        for (int j = 0; j < 7; j++) {
            for (int n = 0; n < 2; n++) {
                for (int i = n; i < n + 4; i++) {
                    x = value.getValue(i, j);
                    sum = sum + x;
                    if (sum == 4) {
                        value.gameEnd(1);
                    } else if (sum == 8) {
                        value.gameEnd(2);
                    }
                    if (sum == 12) {
                        value.gameEnd(3);
                    } else if (sum == 16) {
                        value.gameEnd(4);
                    }
                }
            }
        }
        //to check if game ended diagonally
        for (int i = 0; i < 4; i++) {
            for (int j = 3; j >= 0; j--) {
                sum = sum + value.getValue(i, j);
                if (sum == 4) {
                    value.gameEnd(1);
                } else if (sum == 8) {
                    value.gameEnd(2);
                }
                if (sum == 12) {
                    value.gameEnd(3);
                } else if (sum == 16) {
                    value.gameEnd(4);
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int n = 0; n < 4; n++) {
                for (int j = 4; j >= 0; j--) {
                    sum = sum + value.getValue(i, j);
                    if (sum == 4) {
                        value.gameEnd(1);
                    } else if (sum == 8) {
                        value.gameEnd(2);
                    }
                    if (sum == 12) {
                        value.gameEnd(3);
                    } else if (sum == 16) {
                        value.gameEnd(4);
                    }
                }
            }
        }
    }
    }

