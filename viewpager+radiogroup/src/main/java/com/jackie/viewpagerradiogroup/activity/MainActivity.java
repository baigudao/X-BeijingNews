package com.jackie.viewpagerradiogroup.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.jackie.viewpagerradiogroup.R;
import com.jackie.viewpagerradiogroup.base.BasePager;
import com.jackie.viewpagerradiogroup.pager.GovaffairPager;
import com.jackie.viewpagerradiogroup.pager.HomePager;
import com.jackie.viewpagerradiogroup.pager.NewsCenterPager;
import com.jackie.viewpagerradiogroup.pager.SettingPager;
import com.jackie.viewpagerradiogroup.pager.SmartServicePager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private ViewPager viewPager;
    private RadioGroup rg_main;
    private List<BasePager> basePagers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        //准备数据
        basePagers = new ArrayList<>();
        basePagers.add(new HomePager(MainActivity.this));
        basePagers.add(new NewsCenterPager(MainActivity.this));
        basePagers.add(new SmartServicePager(MainActivity.this));
        basePagers.add(new GovaffairPager(MainActivity.this));
        basePagers.add(new SettingPager(MainActivity.this));
        //设置ViewPager的适配器
        viewPager.setAdapter(new MyPagerAdapter());
        //设置默认选中首页
        rg_main.check(R.id.rb_home);
        //监听某个页面被选中，初始对应的页面的数据
        viewPager.addOnPageChangeListener(new MyOnPageChangeListener());
        //设置RadioGroup的选中状态改变的监听
        rg_main.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        rg_main = (RadioGroup) findViewById(R.id.rg_main);
    }

    class MyPagerAdapter extends PagerAdapter {
        /**
         * 数量
         *
         * @return
         */
        @Override
        public int getCount() {
            return basePagers == null ? 0 : basePagers.size();
        }

        /**
         * @param view
         * @param object
         * @return
         */
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            BasePager basePager = basePagers.get(position);
            View rootView = basePager.rootView;
            //初始化视图的数据
            basePager.initData();
            container.addView(rootView);
            return rootView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    rg_main.check(R.id.rb_home);
                    break;
                case 1:
                    rg_main.check(R.id.rb_newscenter);
                    break;
                case 2:
                    rg_main.check(R.id.rb_smartservice);
                    break;
                case 3:
                    rg_main.check(R.id.rb_govaffair);
                    break;
                case 4:
                    rg_main.check(R.id.rb_setting);
                    break;
                default:
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.rb_home://主页radioButton的id，false代表没有动画
                    viewPager.setCurrentItem(0, false);
                    break;
                case R.id.rb_newscenter://新闻中心radioButton的id
                    viewPager.setCurrentItem(1, false);
                    break;
                case R.id.rb_smartservice://智慧服务radioButton的id
                    viewPager.setCurrentItem(2, false);
                    break;
                case R.id.rb_govaffair://政要指南的RadioButton的id
                    viewPager.setCurrentItem(3, false);
                    break;
                case R.id.rb_setting://设置中心RadioButton的id
                    viewPager.setCurrentItem(4, false);
                    break;
                default:
                    break;
            }
        }
    }
}
