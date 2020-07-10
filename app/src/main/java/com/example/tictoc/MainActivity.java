package com.example.tictoc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameActive= true;

    int activePlayer =0;
    int []  gameState={2, 2, 2, 2, 2, 2, 2, 2, 2};

    int[][] winPositions =  {{0,1,2},  {3,4,5},  {6,7,8},
                             {0,3,6},  {1,4,7}, {2,5,8},
                             {0,4,8},  {2,4,6}
                            };

public void TapTap(View view) {
    ImageView img =(ImageView) view;
    int tappedImage = Integer.parseInt(img.getTag().toString());
    if(!gameActive){
        gamereset(view);
    }
    if(gameState[tappedImage]== 2) {
        gameState[tappedImage] = activePlayer;
        img.setTranslationY(-1000f);
        if (activePlayer == 0) {
            img.setImageResource(R.drawable.x);
            activePlayer = 1;
            TextView Status = findViewById(R.id.Status);
            Status.setText("O's Turn Tap to Play");
        } else {
            img.setImageResource(R.drawable.o);
            activePlayer = 0;
            TextView Status = findViewById(R.id.Status);
            Status.setText("X's Turn Tap to Play");
        }

        img.animate().translationYBy(1000f).setDuration(300);
    }
    //checking win

    for(int[] winPostionion: winPositions){
        if(gameState[winPostionion[0]] == gameState[winPostionion[1]] &&
                gameState[winPostionion[1]] == gameState[winPostionion[2]] &&
                        gameState[winPostionion[0]]!=2)
        {
            String winnerstr;
            gameActive= false;
            if(gameState[winPostionion[0]] == 0)
            {
                winnerstr ="X has won the Match";
            }
            else{
                winnerstr ="O has won the Match";
            }
            //updating the Status Bar
            TextView Status = findViewById(R.id.Status);
            Status.setText(winnerstr);
        }
    }
}



    public void gamereset (View view){
        gameActive =true;
        activePlayer =0;
        for(int i=0;i<gameState.length;i++)
        {
            gameState[i]= 2;
        }
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);

        TextView Status = findViewById(R.id.Status);
        Status.setText("X's Turn Tap to Play");

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
