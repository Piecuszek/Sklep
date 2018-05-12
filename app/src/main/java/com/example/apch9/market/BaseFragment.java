package com.example.apch9.market;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.example.apch9.market.navigation.NavigationInterface;


public class BaseFragment extends Fragment {

    private NavigationInterface navigation = null;

    public NavigationInterface getNavigation() {
        return navigation;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            navigation = (NavigationInterface) context;
        } catch (Exception ex) {
            throw new IllegalStateException("Root activity dont implement correct navigation interface");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        navigation = null;
    }
}
