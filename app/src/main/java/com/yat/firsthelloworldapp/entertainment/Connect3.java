package com.yat.firsthelloworldapp.entertainment;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.yat.firsthelloworldapp.R;

public class Connect3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect3);
    }

    boolean gameIsActive = true; // game is running
    boolean gameIsOver = true;  // game is over
    boolean someOneWon = false;  // some one has won
    int player = 0;   // zero = O  , 1 = X
    int gameState[] = {2, 2, 2, 2, 2, 2, 2, 2, 2};   // 2 means unPlayed
    int winningPosition[][] = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}};    // position which player can win

    public void dropXO(View view) {

        ImageView xoImage = (ImageView) view;  //casting

        int tappedXO = Integer.parseInt(xoImage.getTag().toString()); //get image by Tag
        if (gameState[tappedXO] == 2 && gameIsActive) { //check if there is place empty and the game is running
            gameState[tappedXO] = player;  // put player in the place
            xoImage.setTranslationY(-1000f);  // transition
            if (player == 0) {
                xoImage.setImageResource(R.drawable.o);  //set O image
                player = 1;
            } else {
                xoImage.setImageResource(R.drawable.x); // set X image
                player = 0;
            }
            xoImage.animate().translationYBy(1000f).rotation(360).setDuration(1000); // animation
        }

        for (int[] winningPositions : winningPosition) {
            if (gameState[winningPositions[0]] == gameState[winningPositions[1]]
                    && gameState[winningPositions[1]] == gameState[winningPositions[2]]
                    && gameState[winningPositions[0]] != 2) {  //check if someone has won
                gameIsActive = false;  // game is stopped
                someOneWon = true;  //some one has won


                //someone has won
                String winner = "x";

                if (gameState[winningPositions[0]] == 0) {
                    winner = "O";
                }
                TextView txWinner = findViewById(R.id.tx_winner);
                txWinner.setText("The winner is " + winner);  //display the winners

                LinearLayout winnerLayout = findViewById(R.id.winner_layout);
                winnerLayout.setVisibility(View.VISIBLE);
            } else {
                gameIsOver = true;  //game is over

                for (int state : gameState) {
                    if (state == 2) // check if there is place available
                        gameIsOver = false;
                }
                if (gameIsOver && !someOneWon) { //check that the game is over and no one has won
                    TextView txWinner = findViewById(R.id.tx_winner);
                    txWinner.setText("It's Draw"); // display its draw

                    LinearLayout winnerLayout = findViewById(R.id.winner_layout);
                    winnerLayout.setVisibility(View.VISIBLE);

                }


            }
        }


    }


    public void playAgain(View view) {
        gameIsActive = true;  // return to the game
        someOneWon =false;
        LinearLayout winnerLayout = findViewById(R.id.winner_layout); //casting
        winnerLayout.setVisibility(View.INVISIBLE);
        player = 0; // let O start first

        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = 2; // mark all places as unPlayed

        }
//        for (int i : gameState){
//        }

        GridLayout gridLayout = findViewById(R.id.grid_layout_board);   // casting
        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);  //reset images
        }


    }
}