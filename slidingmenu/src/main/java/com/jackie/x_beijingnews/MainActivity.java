package com.jackie.x_beijingnews;

import android.os.Bundle;
import android.util.DisplayMetrics;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity {

    private int screeWidth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化侧滑
        initSliding();
    }

    private void initSliding() {
        //设置主页面
        setContentView(R.layout.activity_main);
        //设置左侧页面
        setBehindContentView(R.layout.activity_left_menu);
        //设置显示的模式
        SlidingMenu slidingMenu = getSlidingMenu();
        slidingMenu.setMode(SlidingMenu.LEFT);
        //设置滑动模式
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        //设置主页面占屏幕的宽度
        //a,先得到屏幕的宽度
        DisplayMetrics outmetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(outmetrics);
        screeWidth = outmetrics.widthPixels;//屏幕宽
        slidingMenu.setBehindOffset((int) (screeWidth * 0.625));
    }
}
