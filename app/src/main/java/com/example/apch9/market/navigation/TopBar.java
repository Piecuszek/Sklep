package com.example.apch9.market.navigation;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.apch9.market.R;

public class TopBar extends RelativeLayout {

        private ImageView back, menu;
        private TopBarInteractions topBarInteractions;

        public TopBar(Context context) {
                super(context);
                init(context, null, -1, -1);
        }

        public TopBar(Context context, AttributeSet attrs) {
                super(context, attrs);
                init(context, attrs, -1, -1);
        }

        public TopBar(Context context, AttributeSet attrs, int defStyleAttr) {
                super(context, attrs, defStyleAttr);
                init(context, attrs, defStyleAttr, -1);
        }

        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        public TopBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
                super(context, attrs, defStyleAttr, defStyleRes);
                init(context, attrs, defStyleAttr, defStyleRes);
        }

        private void init(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
                inflate(context, R.layout.top_bar, this);

                back = findViewById(R.id.back);
                menu = findViewById(R.id.menu);

                menu.setOnClickListener(view -> {
                    if (topBarInteractions != null) {
                        topBarInteractions.onMenuClick();
                    }
                });

                back.setOnClickListener(view -> {
                    if (topBarInteractions != null) {
                        topBarInteractions.onBackClick();
                    }
                });
        }

        public void showBack(boolean shouldShow) {
            if (shouldShow) {
                back.setVisibility(VISIBLE);
            } else {
                menu.setVisibility(GONE);
            }
        }

        public void setTopBarInteractions(TopBarInteractions interactions) {
                this.topBarInteractions = interactions;
        }

        public interface TopBarInteractions {
            void onMenuClick();
            void onBackClick();
        }
}