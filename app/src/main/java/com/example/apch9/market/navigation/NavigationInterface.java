package com.example.apch9.market.navigation;

import android.app.FragmentManager;

import com.example.apch9.market.BaseFragment;

public interface NavigationInterface {

    void changeFragment(BaseFragment fragment);
    void changeFragment(BaseFragment fragment, boolean addToBackStack);
    void goBack();
    FragmentManager getFragmentManager();

}
