package com.example.felipe.scorekeeper;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.felipe.scorekeeper.R.id.eqA;

public class MainActivity extends AppCompatActivity {
    private int resultA = 0;
    private int resultB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayForTeamA(0);
        displayForTeamB(0);
    }

    // team A
    private void displayForTeamA(int score){
        TextView scroreViewA = (TextView) findViewById(R.id.team_a_scoreA);
        TextView scroreViewB = (TextView) findViewById(R.id.team_a_scoreB);
        scroreViewA.setText(String.valueOf(score));

        int colorWinner = ContextCompat.getColor(this, R.color.green);
        int colorDefault = ContextCompat.getColor(this,R.color.colorPrimaryDark);

        //  muda a cor da equipe que esta vencendo para verde, em caso de empate volta para a cor padrao.

        if(resultA == resultB){
            scroreViewA.setTextColor(colorDefault);
            scroreViewB.setTextColor(colorDefault);

        }else if(resultA < resultB){
            scroreViewA.setTextColor(colorDefault);
            scroreViewB.setTextColor(colorWinner);

        }else{
            scroreViewB.setTextColor(colorDefault);
            scroreViewA.setTextColor(colorWinner);
        }
    }

    public void oneAddA(View view){
        resultA += 1;
        displayForTeamA(resultA);
    }

    public void twoAddA(View view){
        resultA += 2;
        displayForTeamA(resultA);
    }

    public void threeAddA(View view){
        resultA += 3;
        displayForTeamA(resultA);
    }

//    team B
    private void displayForTeamB(int score){
        TextView scroreViewA = (TextView) findViewById(R.id.team_a_scoreA);
        TextView scroreViewB = (TextView) findViewById(R.id.team_a_scoreB);
        scroreViewB.setText(String.valueOf(score));

        int colorWinner = ContextCompat.getColor(this, R.color.green);
        int colorDefault = ContextCompat.getColor(this,R.color.colorPrimaryDark);

        //  muda a cor da equipe que esta vencendo para verde, em caso de empate volta para a cor padrao.

        if(resultA == resultB){

            scroreViewA.setTextColor(colorDefault);
            scroreViewB.setTextColor(colorDefault);

        }else if(resultA > resultB){
            scroreViewA.setTextColor(colorWinner);
            scroreViewB.setTextColor(colorDefault);
        }else{
            scroreViewB.setTextColor(colorWinner);
            scroreViewA.setTextColor(colorDefault);
        }
    }

    public void oneAddB(View view){
        resultB += 1;
        displayForTeamB(resultB);
    }

    public void twoAddB(View view){
        resultB += 2;
        displayForTeamB(resultB);
    }

    public void threeAddB(View view){
        resultB += 3;
        displayForTeamB(resultB);
    }

//    reset
    public void reset(View view){

        if(resultA >0 || resultB >0){
            resultA = 0;
            resultB = 0;

            Toast.makeText(this, "Pontuacao resetada!", Toast.LENGTH_SHORT).show();

            displayForTeamA(resultA);
            displayForTeamB(resultB);
        }else{
            Toast.makeText(this, "Não há pontos para resetar!", Toast.LENGTH_SHORT).show();
        }
    }

}
