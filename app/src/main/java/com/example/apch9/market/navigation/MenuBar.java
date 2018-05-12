package com.example.apch9.market.navigation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.apch9.market.R;

public class MenuBar extends RelativeLayout {

    private LinearLayout start, list, markets;
    private MenuInteractions menuInteractions;

    public MenuBar(Context context) {
        super(context);
        init(context);
    }

    public MenuBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MenuBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public MenuBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.menu_bar, this);
        start = findViewById(R.id.start);
        list = findViewById(R.id.list);
        markets = findViewById(R.id.markets);

        start.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (menuInteractions != null) {
                    menuInteractions.onStartClick();
                }
            }
        });

        list.setOnClickListener(view -> {
            if (menuInteractions != null) {
                menuInteractions.onListClick();
            }
        });

        markets.setOnClickListener(view -> {
            if (menuInteractions != null) {
                menuInteractions.onMarketsClick();
            }
        });
    }

    public void setMenuInteractions(MenuInteractions menuInteractions) {
        this.menuInteractions = menuInteractions;
    }

    public interface MenuInteractions {
        void onStartClick();
        void onListClick();
        void onMarketsClick();
    }
}
