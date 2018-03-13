package com.example.android.udacityproject;

import android.content.DialogInterface;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int scoreA = 0, faulA = 0;
    int scoreB = 0, faulB = 0;
    String mes = "";
    boolean team_a=false, team_b=false;
    String teamTextA="A", teamTextB="B";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayTeamA(scoreA);
        displayTeamB(scoreB);
        displayTeamFaulA(faulA);
        displayTeamFaulB(faulB);
    }
    public void teamA(View view)
    {
        team_a=true;
        openEditBox();
    }

    public void teamB(View view)
    {
        team_b=true;
        openEditBox();
    }
    public void openEditBox()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Write Team Name");

        // Set up the input
        final EditText input = new EditText(this);
        // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(input.length()<6) {
                    String teamText = "TEAM: " + input.getText().toString();

                    if(team_a) {
                        TextView textNew = findViewById(R.id.team_name_a);
                        textNew.setText(teamText);
                        teamTextA=input.getText().toString();
                        team_a=false;
                    }
                    if(team_b)
                    {
                        TextView textNew = findViewById(R.id.team_name_b);
                        textNew.setText(teamText);
                        teamTextB=input.getText().toString();
                        team_b=false;
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Enter 5 character",Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
    public void increaseA(View view) {
        scoreA += 1;
        displayTeamA(scoreA);
    }

    public void increaseB(View view) {
        scoreB += 1;
        displayTeamB(scoreB);
    }

    public void increaseFaulA(View view) {
        faulA += 1;
        displayTeamFaulA(faulA);
    }

    public void increaseFaulB(View view) {
        faulB += 1;
        displayTeamFaulB(faulB);
    }

    public void reset(View view) {
        scoreA = 0;
        scoreB = 0;
        faulA = 0;
        faulB = 0;
        mes = "";
        displayTeamA(scoreA);
        displayTeamB(scoreB);
        displayTeamFaulA(faulA);
        displayTeamFaulB(scoreB);
        TextView messageView = findViewById(R.id.message);
        messageView.setText(mes);
        teamTextA="TEAM A";
        TextView teamA= findViewById(R.id.team_name_a);
        teamA.setText(teamTextA);
        teamTextB="TEAM B";
        TextView teamB= findViewById(R.id.team_name_b);
        teamB.setText(teamTextB);
    }

    public void showmessage(View view) {
        displayMessage();
    }

    public void displayMessage() {
        if (scoreA > scoreB) {
            TextView messageView = findViewById(R.id.message);
            mes = "Team "+teamTextA+" is winner.";
            messageView.setText(mes);
        } else if (scoreB > scoreA) {
            mes = "Team "+teamTextB+" is winner.";
            TextView messageView = findViewById(R.id.message);
            messageView.setText(mes);
        } else {
            mes = "Scorless.";
            TextView messageView = findViewById(R.id.message);
            messageView.setText(mes);
        }

    }

    public void displayTeamA(int score) {
        TextView scoreView = findViewById(R.id.team_a);
        scoreView.setText(String.valueOf(score));
    }

    public void displayTeamB(int score) {
        TextView scoreView = findViewById(R.id.team_b);
        scoreView.setText(String.valueOf(score));
    }

    public void displayTeamFaulA(int score) {
        TextView scoreView = findViewById(R.id.faul_a);
        scoreView.setText(String.valueOf(score));
    }

    public void displayTeamFaulB(int score) {
        TextView scoreView = findViewById(R.id.faul_b);
        scoreView.setText(String.valueOf(score));
    }

}
