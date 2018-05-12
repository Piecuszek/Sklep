package com.example.apch9.market;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.apch9.market.fragments.HomeFragment;
import com.example.apch9.market.navigation.MenuBar;
import com.example.apch9.market.navigation.NavigationInterface;
import com.example.apch9.market.navigation.TopBar;

public class MenuActivity extends AppCompatActivity implements NavigationInterface, TopBar.TopBarInteractions, FragmentManager.OnBackStackChangedListener, MenuBar.MenuInteractions {

    private TopBar topBar;
    private FragmentManager manager;
    private DrawerLayout drawerLayout;
    private MenuBar menuBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        manager = getSupportFragmentManager();
        findViews();
        setListeners();
        changeFragment(HomeFragment.newInstance(), false);
    }

    private void findViews() {
        topBar = findViewById(R.id.top_bar);
        drawerLayout = findViewById(R.id.drawer_layout);
        menuBar = findViewById(R.id.menu_bar);
    }

    private void setListeners() {
        menuBar.setMenuInteractions(this);
        topBar.setTopBarInteractions(this);
        manager.addOnBackStackChangedListener(this);
    }

    private void closeDrawer() {
        drawerLayout.closeDrawer(GravityCompat.END);
    }

    private void openDrawer() {
        drawerLayout.openDrawer(GravityCompat.END);
    }

    private void navigateTo(Fragment fragment, boolean addToBackStack) {
        if (manager == null || fragment == null) {
            return;
        }

        if (manager.getFragments() != null) {
            Fragment current = manager.findFragmentById(R.id.fragment_container);
            if (current != null && fragment.getClass().equals(current.getClass())) {
                Log.w("BaseActivity", "Fragment navigation failed, possible duplicate entry %s");
            }
        }

        FragmentTransaction transaction = manager.beginTransaction();
        if (addToBackStack) {
            transaction.addToBackStack(fragment.toString());
        }
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
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
    public void changeFragment(BaseFragment fragment) {
        navigateTo(fragment, true);
    }

    @Override
    public void changeFragment(BaseFragment fragment, boolean addToBackStack) {
        navigateTo(fragment, addToBackStack);
    }

    @Override
    public void goBack() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void onStartClick() {
        changeFragment(HomeFragment.newInstance());
        closeDrawer();
    }

    @Override
    public void onListClick() {
        changeFragment(HomeFragment.newInstance());
        closeDrawer();
    }

    @Override
    public void onMarketsClick() {
        changeFragment(HomeFragment.newInstance());
        closeDrawer();
    }

    @Override
    public void onMenuClick() {
        openDrawer();
    }

    @Override
    public void onBackClick() {
        onBackPressed();
    }
}
