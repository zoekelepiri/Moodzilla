package com.example.androidapp;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.ArrayList;

/*Add and delete your tasks*/

public class Task extends AppCompatActivity {
    private DataBase taskHelper;
    private ListView TaskList;
    private ArrayAdapter<String> arrAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task);

        taskHelper = new DataBase(this);
        TaskList = (ListView) findViewById(R.id.list_todo);

       updateUI();

        //Hide the default navigation bar
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        //Set home slc
        bottomNavigationView.setSelectedItemId(R.id.tasks);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    //show a dialog box to add task
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_task:
                final EditText taskEdit = new EditText(this);
                AlertDialog dialog = new AlertDialog.Builder(this)
                        .setTitle("Add a new task").setMessage("What do you want to do next?").setView(taskEdit)
                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String task = String.valueOf(taskEdit.getText());
                                taskHelper.addTask(task);
                                updateUI();
                            }
                        })
                        .setNegativeButton("Cancel", null).create();
                dialog.show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //delete task from the view
    public void deleteTask(View view) {
        View parent = (View) view.getParent();
        TextView taskTextView = (TextView) parent.findViewById(R.id.title_task);
        String task = String.valueOf(taskTextView.getText());
        taskHelper.deleteTask(task);
        updateUI();
    }

    //update the list view
    public void updateUI() {
        ArrayList<String> taskList = new ArrayList<>();
        SQLiteDatabase db = taskHelper.getReadableDatabase();
        Cursor cursor = db.query(DataBase.TABLE_TODO,
                new String[]{DataBase.COLUMN_ID, DataBase.COLUMN_TASK_TITLE},
                null, null, null, null, null);
        while (cursor.moveToNext()) {
            int idx = cursor.getColumnIndex(DataBase.COLUMN_TASK_TITLE);
            taskList.add(cursor.getString(idx));
        }

        //if there are no tasks in the list view, add it
        if (arrAdapter == null) {
            arrAdapter = new ArrayAdapter<>(this, R.layout.todo, R.id.title_task, taskList);
            TaskList.setAdapter(arrAdapter);
        }

        //if there are tasks in the list find the position and store the changes
        else {
            arrAdapter.clear();
            arrAdapter.addAll(taskList);
            arrAdapter.notifyDataSetChanged();

        }
        cursor.close();
        db.close();
    }

}
