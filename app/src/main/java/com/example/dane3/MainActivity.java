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
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    String[] UczenList;
    //dane dla fragmetu 1
    InputStream inputStreamCounterUczen;
    BufferedReader bufferedReaderCounterUczen;
    InputStream inputStreamLoaderUczen;
    BufferedReader BufferedReaderLoaderUczen;
    int intCountUczen;

   //====
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


        //========-========= dodanie elementow do fragemtu 1
        ListView listView= (ListView) findViewById(R.id.litsview_fragment1);
        inputStreamCounterUczen = this.getResources().openRawResource(R.raw.dane_uczen);
        bufferedReaderCounterUczen = new BufferedReader(new InputStreamReader(inputStreamCounterUczen));

        inputStreamLoaderUczen = this.getResources().openRawResource(R.raw.dane_uczen);
        BufferedReaderLoaderUczen = new BufferedReader(new InputStreamReader(inputStreamLoaderUczen));

        try{
            while (bufferedReaderCounterUczen.readLine()!=null){
            intCountUczen++;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        UczenList = new String[intCountUczen];

        try{
            for(int i=0;i<intCountUczen; i++){
                UczenList[i] = BufferedReaderLoaderUczen.readLine();

            }
        }catch(Exception e){
            e.printStackTrace();
        }





    }
}