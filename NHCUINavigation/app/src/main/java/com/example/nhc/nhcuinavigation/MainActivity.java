package com.example.nhc.nhcuinavigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.nhc.nhcuinavigation.SwipeViewWithTab.SwipeViewWithTabActivity;
import com.example.nhc.nhcuinavigation.SwipeViewWithTabAndNavigationDrawer.SwipeViewWithTabAndNavigationDrawerActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @OnClick(R.id.button)
    void onClickSwipeViewBtn() {
        gotoActivity(SwipeViewWithTabActivity.class);
    }

    @OnClick(R.id.button2)
    void onClickSwipeViewBtn2() {
        gotoActivity(SwipeViewWithTabAndNavigationDrawerActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    private void gotoActivity(Class activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }
}
