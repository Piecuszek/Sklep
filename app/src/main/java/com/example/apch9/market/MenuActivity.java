package com.example.apch9.market;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.apch9.market.navigation.TopBar;

public class MenuActivity extends AppCompatActivity implements TopBar.TopBarInteractions, FragmentManager.OnBackStackChangedListener {

    private TopBar topBar;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        manager = getSupportFragmentManager();
        findViews();
        setListeners();
    }

    private void findViews() {
        topBar = findViewById(R.id.top_bar);
    }

    private void setListeners() {
        topBar.setTopBarInteractions(this);
        manager.addOnBackStackChangedListener(this);
    }


    @Override
    public void onBackStackChanged() {
        if (getSupportFragmentManager().getBackStackEntryCount() >= 1) {
            topBar.showBack(true);
        } else {
            topBar.showBack(false);
        }
    }

    @Override
    public void onMenuClick() {

    }

    @Override
    public void onBackClick() {
        onBackPressed();
    }
}
