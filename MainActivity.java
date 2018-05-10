package com.developer.viruninc.ckccapp;

import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  Set toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar();
        // Intergrate toolbar
        final DrawerLayout drawerLayout = findViewById(R.id.layout_Drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        // Handle Navigation Drawer
        NavigationView navigationView = findViewById(R.id.nvg_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.it_home:
                        onClickedHome();
                        break;
                    case R.id.it_news:
                        onClickedNews();
                        break;
                    case R.id.it_event:
                        onClickedEvent();
                        break;
                    case R.id.it_setting:
                        onClickeSetting();
                        break;
                    case R.id.it_help:
                        onClickedHelp();
                        break;
                }
                return false;
            }
            private void onClickedHome() {
                drawerLayout.closeDrawers();
                HomeFragment homeFragment = new HomeFragment();
                android.app.FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.lyt_fragment, homeFragment);
                fragmentTransaction.commit();
            }

            private void onClickedNews() {
                drawerLayout.closeDrawers();
                NewsFragment newsFragment = new NewsFragment();
                android.app.FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.lyt_fragment, newsFragment);
                fragmentTransaction.commit();
            }

            private void onClickedEvent() {
                drawerLayout.closeDrawers();
                EventFragment eventFragment = new EventFragment();
                android.app.FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.lyt_fragment, eventFragment);
                fragmentTransaction.commit();
            }

            private void onClickeSetting() {
                drawerLayout.closeDrawers();
                SettingFragment settingFragment = new SettingFragment();
                android.app.FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.lyt_fragment, settingFragment);
                fragmentTransaction.commit();
            }

            private void onClickedHelp() {
                drawerLayout.closeDrawers();
                HelpFragment helpFragment = new HelpFragment();
                android.app.FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.lyt_fragment, helpFragment);
                fragmentTransaction.commit();
            }
        });
    }
}
