package com.example.androidapp;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

/*Here i have the images and click on them*/
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

/*First activity after the welcome page, you can choose a mood (image)*/

public class MoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moods);

        //Hide the default navigation bar
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        //Set home slc
       bottomNavigationView.setSelectedItemId(R.id.hud);

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

    }

    //clicking on the mood image (MoodActivityIntent.class -->shows the quotes for each)
    /*happy message*/
    public void Happy(View view) {
        Intent intent = new Intent(this, MoodActivityIntent.class);
        intent.putExtra("mood","happy");
        startActivity(intent);
    }

    /*sad message*/
    public void Sad(View view) {
        Intent intent = new Intent(this, MoodActivityIntent.class);
        intent.putExtra("mood","sad");
        startActivity(intent);
    }

    /*surprise message*/
    public void Surprise(View view) {
        Intent intent = new Intent(this, MoodActivityIntent.class);
        intent.putExtra("mood","surprise");
        startActivity(intent);
    }

    /*Fear message*/
    public void Fear(View view) {
        Intent intent = new Intent(this, MoodActivityIntent.class);
        intent.putExtra("mood","fear");
        startActivity(intent);
    }

    /*Calm message*/
    public void Calm(View view) {
        Intent intent = new Intent(this, MoodActivityIntent.class);
        intent.putExtra("mood","calm");
        startActivity(intent);
    }

    /*Disgust message*/
    public void Disgust(View view) {
        Intent intent = new Intent(this, MoodActivityIntent.class);
        intent.putExtra("mood","disgust");
        startActivity(intent);
    }

    /*Contempt message*/
    public void Contempt(View view) {
        Intent intent = new Intent(this, MoodActivityIntent.class);
        intent.putExtra("mood","contempt");
        startActivity(intent);
    }

    /*Angry message*/
    public void Angry(View view) {
        Intent intent = new Intent(this, MoodActivityIntent.class);
        intent.putExtra("mood","angry");
        startActivity(intent);
    }
}


