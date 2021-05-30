package com.example.androidapp;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

/*Tips and images*/

public class TipsActivity extends AppCompatActivity {
    //The images
    int[] images = {R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image23,
            R.drawable.image7,
            R.drawable.image24,
            R.drawable.image9,
            R.drawable.image10,
            R.drawable.image11,
            R.drawable.image12,
            R.drawable.image13,
            R.drawable.image14,
            R.drawable.image15,
            R.drawable.image16,
            R.drawable.image17,
            R.drawable.image18,
            R.drawable.image19,
            R.drawable.image20,
            R.drawable.image21,
            R.drawable.image22,};

    //The quotes
    String[] Quote = {"Take time to know yourself",
            "Be more mindful and self-aware",
            "Define what happiness and success mean to you",
            "Smile and laugh more, it keeps the negative blues away",
            "Learn something new every day",
            "Remember that no one is perfect and let yourself move forward",
            "Be grateful everyday",
            "Spend more time with your friends",
            "View challenges as opportunities",
            "Use the 'We'll see method' ",
            "Remember that you are in charge of your life ",
            "Don't fall into the trap of 'I'll be happy when...'",
            "Keep a Gratitude Journal",
            "Don't waste your energy on negative thought",
            "Use “Habit Stacking” to Build Good Habits",
            "Start with the smallest doable step",
            "Be your best at all times",
            "Go easy on yourself during the hard times",
            "Do something nice for someone else",
            "Find humor in bad situations",
            "Believe in yourself",
            "List five things that you are grateful for right now"};

    ListView lView;
    ListAdapter lAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        //Hide the default navigation bar
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Attach the adapter to a ListView
        lView = (ListView) findViewById(R.id.tipsadvices);
        lAdapter = new ListAdapter(TipsActivity.this, Quote, images);
        lView.setAdapter(lAdapter);

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        //Set home slc
        bottomNavigationView.setSelectedItemId(R.id.tips);

        //item listener, click on navigation bar's buttons and move to another class
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.hud:
                        startActivity(new Intent(getApplicationContext(), MoodActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.tasks:
                        startActivity(new Intent(getApplicationContext(), Task.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.tips:
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
}
