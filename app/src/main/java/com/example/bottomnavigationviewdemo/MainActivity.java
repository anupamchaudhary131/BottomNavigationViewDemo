package com.example.bottomnavigationviewdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnView = findViewById(R.id.bnView);


        bnView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                if(id == R.id.nav_home)
                {
                    LoadFragment(new AFragment(), true);
                }
                else if(id == R.id.nav_search)
                {
                    LoadFragment(new BFragment(), false);
                }
                else if(id == R.id.nav_utilities)
                {
                    LoadFragment(new CFragment(), false);
                }
                else if(id == R.id.nav_contactUs)
                {
                    LoadFragment(new DFragment(), false);
                }
                else
                {
                    LoadFragment(new EFragment(), false);
                }

                bnView.setSelectedItemId(R.id.nav_home);

                return true;
            }
        });

    }


    public void LoadFragment(Fragment fragment, boolean flag)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(flag) {
            ft.add(R.id.container, fragment);
        }
        else
        {
            ft.replace(R.id.container, fragment);
        }
        ft.commit();
    }
}