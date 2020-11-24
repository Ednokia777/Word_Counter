package com.ednokia.wordcounter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView display, progress;
    List<String> worldList;
    int counter = 1;
    int i = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.dispalay);
        progress = findViewById(R.id.progress);
        worldList = new ArrayList<>();

        worldList.add("cat");//i want to display this word firstly
        worldList.add("dog");//it after click
        worldList.add("monkey");//after it
        worldList.add("bird");//after it
        worldList.add("fish");//etc
        worldList.add("home");//etc
        worldList.add("car");//etc
    }


    public void onClickYes(View view) {
        if( i >=worldList.size()) return;
        display.setText(worldList.get(i));
        //worldList.remove(i); тут я хотел удалить из списка уже отмеченное слово.
        progress.setText(counter+"");
        i++;
        counter++;
    }

    public void onClickNo(View view) {
        Toast.makeText(this, "Size is " + worldList.size(), Toast.LENGTH_SHORT).show();
        i = 0;
        counter = 0;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.yes :
                intent = new Intent(MainActivity.this, YesActivity.class);
                startActivity(intent);
                break;
            case R.id.no :
                intent = new Intent(MainActivity.this, NoActivity.class);
                startActivity(intent);
                break;
            case R.id.about :
                Toast.makeText(this, "By SaturnPRO", Toast.LENGTH_SHORT).show();
                //openDialogAbout
                break;
        }
        return true;
    }
}