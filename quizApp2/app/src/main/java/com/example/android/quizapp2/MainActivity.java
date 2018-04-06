package com.example.android.quizapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int count=1;
    private boolean optionOne=false;
    private boolean optionTwo=false;
    private boolean optionThree=false;
    private boolean optionFour=false;
    private boolean checkOne=false;
    private boolean checkTwo=false;
    private boolean checkThree=false;
    private boolean checkFour=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void next(View view)
    {
        setContentView(R.layout.activity_question);
    }
    public void next_question(View view)
    {
        TextView question=findViewById(R.id.question);
        TextView quizQuestion=findViewById(R.id.quiz_question);
        TextView optionA=findViewById(R.id.option1);
        TextView optionB=findViewById(R.id.option2);
        TextView optionC=findViewById(R.id.option3);
        TextView optionD=findViewById(R.id.option4);
        TextView money1=findViewById(R.id.money8);
        TextView money2=findViewById(R.id.money7);
        TextView money3=findViewById(R.id.money6);
        TextView money4=findViewById(R.id.money5);
        TextView money5=findViewById(R.id.money4);
        TextView money6=findViewById(R.id.money3);
        TextView money8=findViewById(R.id.money1);
        TextView money=findViewById(R.id.money_text_view);
        TextView edit=findViewById(R.id.edit);
        int cntr=control();

        if(count==1)
        {
            money1.setBackgroundResource(R.color.colorAccent);
            money8.setBackgroundResource(R.color.white);
            question.setText(getString(R.string.question1));
            quizQuestion.setText(getString(R.string.q1));
            optionA.setText(getString(R.string.answ1_1));
            optionB.setText(getString(R.string.answ2_1));
            optionC.setText(getString(R.string.answ3_1));
            optionD.setText(getString(R.string.answ4_1));
            if(cntr==1) {
                Toast.makeText(getApplicationContext(), "Correct Answer 1", Toast.LENGTH_SHORT).show();
                count += 1;
                money1.setBackgroundResource(R.color.white);
                money2.setBackgroundResource(R.color.colorAccent);
                question.setText(getString(R.string.question2));
                quizQuestion.setText(getString(R.string.q2));
                optionA.setText(getString(R.string.answ1_2));
                optionB.setText(getString(R.string.answ2_2));
                optionC.setText(getString(R.string.answ3_2));
                optionD.setText(getString(R.string.answ4_2));
                money.setText(R.string.money1000);
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Wrong Answer 1", Toast.LENGTH_SHORT).show();
            }
        }
        else if(count==2)
        {
            if(cntr==2) {
                Toast.makeText(getApplicationContext(), "Correct Answer 2", Toast.LENGTH_SHORT).show();
                count += 1;
                money2.setBackgroundResource(R.color.white);
                money3.setBackgroundResource(R.color.colorAccent);
                question.setText(getString(R.string.question6));
                quizQuestion.setText(getString(R.string.q3));
                optionA.setText(getString(R.string.answ1_3));
                optionB.setText(getString(R.string.answ2_3));
                optionC.setText(getString(R.string.answ3_3));
                optionD.setText(getString(R.string.answ4_3));
                money.setText(R.string.money5000);
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Wrong Answer 2", Toast.LENGTH_SHORT).show();
            }
        }
        else if(count==3)
        {
            if(cntr==1)
            {
                Toast.makeText(getApplicationContext(),"Correct Answer 3",Toast.LENGTH_SHORT).show();
                count+=1;
                money3.setBackgroundResource(R.color.white);
                money4.setBackgroundResource(R.color.colorAccent);
                question.setText(R.string.question4);
                quizQuestion.setText(R.string.q4);
                optionA.setText(R.string.answ1_4);
                optionB.setText(R.string.answ2_4);
                optionC.setText(R.string.answ3_4);
                optionD.setText(R.string.answ4_4);
                money.setText(R.string.moneyOn);
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Wrong Answer 3", Toast.LENGTH_SHORT).show();
            }
        }
        else if(count==4)
        {
            if(cntr==1)
            {
                Toast.makeText(getApplicationContext(),"Correct Answer 4",Toast.LENGTH_SHORT).show();
                count+=1;
                money4.setBackgroundResource(R.color.white);
                money5.setBackgroundResource(R.color.colorAccent);
                question.setText(getString(R.string.question5));
                quizQuestion.setText(getString(R.string.q5));
                optionA.setText(getString(R.string.answ1_5));
                optionB.setText(getString(R.string.answ2_5));
                optionC.setText(getString(R.string.answ3_5));
                optionD.setText(getString(R.string.answ4_5));
                money.setText(R.string.moneyYirmi);
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Wrong Answer 4", Toast.LENGTH_SHORT).show();
            }
        }
        else if(count==5)
        {
            if(cntr==1)
            {
                Toast.makeText(getApplicationContext(),"Correct Answer 5",Toast.LENGTH_SHORT).show();
                count+=1;
                money5.setBackgroundResource(R.color.white);
                money6.setBackgroundResource(R.color.colorAccent);
                question.setText(getString(R.string.question6));
                quizQuestion.setText(getString(R.string.q6));
                optionA.setText(getString(R.string.answ1_6));
                optionB.setText(getString(R.string.answ2_6));
                optionC.setText(getString(R.string.answ3_6));
                optionD.setText(getString(R.string.answ4_6));
                money.setText(R.string.moneyElli);
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Wrong Answer 5", Toast.LENGTH_SHORT).show();
            }

        }
        else if(count==6)
        {
            if(cntr==3)
            {
                Toast.makeText(getApplicationContext(),"Correct Answer 6",Toast.LENGTH_SHORT).show();
                count+=1;
                setContentView(R.layout.activity_edit);
                optionOne=false;
                optionTwo=false;
                optionThree=false;
                optionFour=false;
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Wrong Answer 6", Toast.LENGTH_SHORT).show();
            }
        }
        else if(count==7)
        {
            String s=edit.getText().toString();
            if(s.equalsIgnoreCase("Sir Walter Raleigh"))
            {
                Toast.makeText(getApplicationContext(),"Correct Answer 7",Toast.LENGTH_SHORT).show();
                count+=1;
                setContentView(R.layout.activity_check);
                optionOne=false;
                optionTwo=false;
                optionThree=false;
                optionFour=false;
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Wrong Answer 7", Toast.LENGTH_SHORT).show();
            }

        }
        else if(count==8)
        {
            CheckBox chk1=findViewById(R.id.checkbox_1);
            CheckBox chk2=findViewById(R.id.checkbox_2);
            CheckBox chk3=findViewById(R.id.checkbox_3);
            CheckBox chk4=findViewById(R.id.checkbox_4);
            if(chk1.isChecked() && chk4.isChecked() && !chk2.isChecked() && !chk3.isChecked())
            {
                Toast.makeText(getApplicationContext(),"Correct Answer 8",Toast.LENGTH_SHORT).show();
                count=1;
                setContentView(R.layout.activity_again);
                TextView res=findViewById(R.id.result);
                res.setText(getString(R.string.money1));
                optionOne=false;
                optionTwo=false;
                optionThree=false;
                optionFour=false;
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Wrong Answer 8", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void onCheckboxClicked(View view)
    {
        boolean checked = ((CheckBox) view).isChecked();
        switch(view.getId()) {
            case R.id.checkbox_1:
                if (checked){
                    checkOne=true;
                }
                break;
            case R.id.checkbox_2:
                if (checked){
                    checkTwo=true;
                }
                break;
            case R.id.checkbox_3:
                if (checked){
                    checkThree=true;
                }
                break;
            case R.id.checkbox_4:
                if (checked){
                    checkFour=true;
                }
                break;
        }
    }
    public void submit(View view)
    {
        int cntrSubmit=control();
        TextView editSubmit=findViewById(R.id.edit);
        setContentView(R.layout.activity_again);
        TextView res=findViewById(R.id.result);

        if(count==1) {
            if (cntrSubmit==1) {
                Toast.makeText(getApplicationContext(), "Your result " + getString(R.string.money8), Toast.LENGTH_SHORT).show();
                res.setText(getString(R.string.money8));
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Your result " + getString(R.string.money9), Toast.LENGTH_SHORT).show();
                res.setText(getString(R.string.money9));
            }
        }
        else if(count==2) {
            if (cntrSubmit == 2)
            {
                Toast.makeText(getApplicationContext(), "Your result " + getString(R.string.money7), Toast.LENGTH_SHORT).show();
                res.setText(getString(R.string.money7));
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Your result " + getString(R.string.money8), Toast.LENGTH_SHORT).show();
                res.setText(getString(R.string.money8));
            }
        }
        else if(count==3){
            if (cntrSubmit == 1)
            {
                Toast.makeText(getApplicationContext(), "Your result " + getString(R.string.money6), Toast.LENGTH_SHORT).show();
                res.setText(getString(R.string.money6));
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Your result " + getString(R.string.money7), Toast.LENGTH_SHORT).show();
                res.setText(getString(R.string.money7));
            }
        }
        else if(count==4) {
            if (cntrSubmit == 1)
            {
                Toast.makeText(getApplicationContext(), "Your result " + getString(R.string.money5), Toast.LENGTH_SHORT).show();
                res.setText(getString(R.string.money5));
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Your result " + getString(R.string.money6), Toast.LENGTH_SHORT).show();
                res.setText(getString(R.string.money6));
            }
        }
        else if(count==5) {
            if (cntrSubmit == 1)
            {
                Toast.makeText(getApplicationContext(), "Your result " + getString(R.string.money4), Toast.LENGTH_SHORT).show();
                res.setText(getString(R.string.money4));
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Your result " + getString(R.string.money5), Toast.LENGTH_SHORT).show();
                res.setText(getString(R.string.money5));
            }
        }
        else if(count==6) {
            if (cntrSubmit == 3)
            {
                Toast.makeText(getApplicationContext(), "Your result " + getString(R.string.money3), Toast.LENGTH_SHORT).show();
                res.setText(getString(R.string.money3));
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Your result " + getString(R.string.money4), Toast.LENGTH_SHORT).show();
                res.setText(getString(R.string.money4));
            }
        }
        else if(count==7) {
            String s=editSubmit.getText().toString();
            if(s.equalsIgnoreCase("Sir Walter Raleigh"))
            {
                Toast.makeText(getApplicationContext(), "Your result " + getString(R.string.money2), Toast.LENGTH_SHORT).show();
                res.setText(getString(R.string.money2));
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Your result " + getString(R.string.money3), Toast.LENGTH_SHORT).show();
                res.setText(getString(R.string.money3));
            }
        }
        else if(count==8) {
            CheckBox chk1=findViewById(R.id.checkbox_1);
            CheckBox chk2=findViewById(R.id.checkbox_2);
            CheckBox chk3=findViewById(R.id.checkbox_3);
            CheckBox chk4=findViewById(R.id.checkbox_4);
            if(chk1.isChecked() && chk4.isChecked() && !chk2.isChecked() && !chk3.isChecked())
            {
                Toast.makeText(getApplicationContext(), "Your result " + getString(R.string.money1), Toast.LENGTH_SHORT).show();
                res.setText(getString(R.string.money1));
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Your result " + getString(R.string.money2), Toast.LENGTH_SHORT).show();
                res.setText(getString(R.string.money2));
            }
        }
        checkOne=false;
        checkTwo=false;
        checkThree=false;
        checkFour=false;

    }
    public int control()
    {
         if(optionOne)
             return 1;
         else if(optionTwo)
             return 2;
         else if(optionThree)
             return 3;
         else if(optionFour)
             return 4;

         return 0;
    }
    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.option1:
                if (checked) {
                    optionOne = true;
                    optionTwo = false;
                    optionThree = false;
                    optionFour = false;
                }
                    break;
            case R.id.option2:
                if (checked) {
                    optionOne = false;
                    optionTwo = true;
                    optionThree = false;
                    optionFour = false;
                }
                    break;
            case R.id.option3:
                if (checked) {
                    optionOne = false;
                    optionTwo = false;
                    optionThree = true;
                    optionFour = false;
                }
                    break;
            case R.id.option4:
                if (checked) {
                    optionOne = false;
                    optionTwo = false;
                    optionThree = false;
                    optionFour = true;
                }
                    break;
        }
    }
    public void again(View view)
    {
        setContentView(R.layout.activity_question);
        count=1;
        optionOne=false;
        optionTwo=false;
        optionThree=false;
        optionFour=false;
        checkOne=false;
        checkTwo=false;
        checkThree=false;
        checkFour=false;
    }
}
