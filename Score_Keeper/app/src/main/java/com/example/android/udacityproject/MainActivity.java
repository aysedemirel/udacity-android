package com.example.android.udacityproject;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreA=0,faulA=0;
    int scoreB=0,faulB=0;
    String mes="";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayTeamA(scoreA);
        displayTeamB(scoreB);
        displayTeamFaulA(faulA);
        displayTeamFaulB(faulB);
    }
    public void increaseA(View view)
    {
        scoreA+=1;
        displayTeamA(scoreA);
    }
    public void increaseB(View view)
    {
        scoreB+=1;
        displayTeamB(scoreB);
    }
    public void increaseFaulA(View view)
    {
        faulA+=1;
        displayTeamFaulA(faulA);
    }
    public void increaseFaulB(View view)
    {
        faulB+=1;
        displayTeamFaulB(faulB);
    }
    public void reset(View view)
    {
        scoreA=0;
        scoreB=0;
        faulA=0;
        faulB=0;
        mes="";
        displayTeamA(scoreA);
        displayTeamB(scoreB);
        displayTeamFaulA(faulA);
        displayTeamFaulB(scoreB);
        TextView messageView=(TextView)findViewById(R.id.message);
        messageView.setText(mes);
    }
    public void showmessage(View view)
    {
        displayMessage(mes);
    }
    public void  displayMessage(String m)
    {
        if(scoreA>scoreB)
        {
            TextView messageView=(TextView)findViewById(R.id.message);
            mes="Team A is winner.";
            messageView.setText(mes);
        }
        else if(scoreB>scoreA)
        {
            mes="Team B is winner.";
            TextView messageView=(TextView)findViewById(R.id.message);
            messageView.setText(mes);
        }
        else
        {
            mes="Scorless.";
            TextView messageView=(TextView)findViewById(R.id.message);
            messageView.setText(mes);
        }

    }
    public void displayTeamA(int score)
    {
        TextView scoreView=(TextView)findViewById(R.id.team_a);
        scoreView.setText(String.valueOf(score));
    }
    public void displayTeamB(int score)
    {
        TextView scoreView=(TextView)findViewById(R.id.team_b);
        scoreView.setText(String.valueOf(score));
    }
    public void displayTeamFaulA(int score)
    {
        TextView scoreView=(TextView)findViewById(R.id.faul_a);
        scoreView.setText(String.valueOf(score));
    }
    public void displayTeamFaulB(int score)
    {
        TextView scoreView=(TextView)findViewById(R.id.faul_b);
        scoreView.setText(String.valueOf(score));
    }
    
}
