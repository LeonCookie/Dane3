package com.example.dane3;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.BufferedReader;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    String[] UczenList;

    InputStream inputStreamCounterUczen;
    BufferedReader bufferedReaderCounterUczen;

    InputStream inputStreamLoaderUczen;
    BufferedReader BufferedReaderLoaderUczen;
    
    BottomNavigationView bottomNavigationView;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new Fragment1()).commit();

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                switch (item.getItemId()){
                    case R.id.item1:
                        fragment= new Fragment1();
                        break;
                    case R.id.item2:
                        fragment= new Fragment2();
                        break;
                    case R.id.item3:
                        fragment= new Fragment3();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,fragment).commit();
                return true;
            }
        });


        //========-=========
        ListView listView= (ListView) findViewById(R.id.litsview_fragment1);
        inputStreamCounterUczen = this.getResources().openRawResource(R.raw.daneUczen);






    }
}