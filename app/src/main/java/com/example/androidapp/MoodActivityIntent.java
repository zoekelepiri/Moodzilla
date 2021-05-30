package com.example.androidapp;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.Random;

/*The showing quote activity, after clicking a mood image on MoodActivity*/

public class MoodActivityIntent extends AppCompatActivity {
    //for the random quote choosing
    String phrase ="";
    Random rnd=new Random();
    int n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_intent);

        //Hide the default navigation bar
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        //Set home slc
        //bottomNavigationView.setSelectedItemId(R.id.hud);

        //item listener, click on navigation bar's buttons and move to another class
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.hud:
                        return true;

                    case R.id.tasks:
                        startActivity(new Intent(getApplicationContext(), Task.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.tips:
                        startActivity(new Intent(getApplicationContext(), TipsActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.about:
                        startActivity(new Intent(getApplicationContext(), About.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        //after clicking on a mood, a quote is showing (random for each)
        String mood = getIntent().getStringExtra("mood");
        switch (mood) {
            case "happy":
                Happy();
                break;
            case "sad":
                Sad();
                break;
            case "angry":
                Angry();
                break;
            case "contempt":
                Contempt();
                break;
            case "disgust":
                Disgust();
                break;
            case "fear":
                Fear();
                break;
            case "calm":
                Calm();
                break;
            case "surprise":
                Surprise();
                break;
        }
    }

    //Random quotes for surprise image
    private void Surprise() {
        n=rnd.nextInt(4);
        if(n==0)
        {
            phrase ="Expect the unexpected. Life is full of wonderful things just waiting to surprise you.";
        }
        else if (n==1)
        {
            phrase ="Surprise is the greatest gift which life can grant us.";
        }
        else if (n==2)
        {
            phrase ="Life is an aggregate of experience, which continually surprises us.";
        }
        else if (n==3)
        {
            phrase ="Let life surprise you. Surprises are always better than promises.";
        }

        TextView textView = (TextView) findViewById(R.id.happytextView);
        textView.setText(phrase);
    }

    //Random quotes for calm image
    private void Calm() {
       int n=rnd.nextInt(4);
        if(n==0)
        {
            phrase ="It's all about finding the calm in the chaos.";
        }
        else if (n==1)
        {
            phrase ="Your calm mind is the ultimate weapon against your challenges.";
        }
        else if (n==2)
        {
            phrase ="Calm is the magic elixir that brings you to a place of balance, harmony and peace.";
        }
        else if (n==3)
        {
            phrase ="Those who are free of resentful thoughts surely find peace.";
        }
        TextView textView = (TextView) findViewById(R.id.happytextView);
        textView.setText(phrase);
    }

    //Random quotes for fear image
    private void Fear() {
        n=rnd.nextInt(4);
        if(n==0)
        {
            phrase ="Forget Everything And Run \n or \nFace Everything And Rise. ";
        }
        else if (n==1)
        {
            phrase ="Don't let the fear of what could happen, make nothing happen.";
        }
        else if (n==2)
        {
            phrase ="He who was overcome his fears will truly be free.";
        }
        else if (n==3)
        {
            phrase ="Everything you want is on the other side of fear.";
        }
        TextView textView = (TextView) findViewById(R.id.happytextView);
        textView.setText(phrase);
    }

    //Random quotes for disgust image
    private void Disgust() {
        n=rnd.nextInt(4);
        if(n==0)
        {
            phrase ="Disgust is the appropriate response to most situations.";
        }
        else if (n==1)
        {
            phrase ="Evermore the world is this marvelous balance of beauty and disgust, magnificence and rats.";
        }
        else if (n==2)
        {
            phrase ="You have to be disgusted with your current circumstances before your circumstances can change.";
        }
        else if (n==3)
        {
            phrase ="Disgust and resolve are two of the great emotions that lead to change.";
        }
        TextView textView = (TextView) findViewById(R.id.happytextView);
        textView.setText(phrase);

    }

    //Random quotes for contempt image
    private void Contempt() {
        if(n==0)
        {
            phrase ="The usual fortune of complaint is to excite contempt more than pity.";
        }
        else if (n==1)
        {
            phrase ="Familiarity breeds contempt.";
        }
        else if (n==2)
        {
            phrase ="Contempt for failure is our cardinal virtue.";
        }
        else if (n==3)
        {
            phrase ="You start to think of contempt as a virus. Infecting individuals first but spreading rapidly through families, communities, nations. Less flashy than hate.";
        }
        TextView textView = (TextView) findViewById(R.id.happytextView);
        textView.setText(phrase);
    }

    //Random quotes for angry image
    private void Angry() {
        n=rnd.nextInt(4);

        if(n==0)
        {
            phrase ="There is no time to be angry, always be busy with love.";
        }
        else if (n==1)
        {
            phrase ="Never go to bed angry, stay up and fight.";
        }
        else if (n==2)
        {
            phrase ="Speak when you are angry and you will make the best speech you'll ever regret.";
        }
        else if (n==3)
        {
            phrase ="Don't get angry quickly. Be kind, be forgiving, be patient.";
        }
        TextView textView = (TextView) findViewById(R.id.happytextView);
        textView.setText(phrase);

    }

    ////Random quotes for sad image
    private void Sad() {
        n=rnd.nextInt(4);

        if(n==0)
        {
            phrase ="What brings us to tears, will lead us to grace. Our pain is never wasted.";
        }
        else if (n==1)
        {
            phrase ="Each day you only have a limited amount of time and energy. Don't waste it stressing and being sad about things you cannot control.";
        }
        else if (n==2)
        {
            phrase ="Sadness is an ocean. Sometimes we drown, while other days we are forced to swim.";
        }
        else if (n==3)
        {
            phrase ="You're allowed to feel messed up cause it doesn't mean you defective but that you are just a human.";
        }
        TextView textView = (TextView) findViewById(R.id.happytextView);
        textView.setText(phrase);
    }

    //Random quotes for happy image
    private void Happy() {
        n=rnd.nextInt(4);

        if(n==0)
        {
            phrase ="You deserve to be happy. You deserve to live a life you are excited about. ";
        }
        else if (n==1)
        {
            phrase ="You are already complete. There is a playful, joyous energy behind what you do.";
        }
        else if (n==2)
        {
            phrase ="Happiness is the secret to all beauty. There is no beauty without happiness.";
        }
        else if (n==3)
        {
            phrase ="It's about loving what you have and being grateful for it. Always find time for the things that make you feel happy.";
        }
        TextView textView = (TextView) findViewById(R.id.happytextView);
        textView.setText(phrase);
    }
    //Return in MoodActivity with onClick Method
    public void Back(View view) {
        Intent intent=new Intent(this,MoodActivity.class);
        startActivity(intent);

    }
}


