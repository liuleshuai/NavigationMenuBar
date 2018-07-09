package com.sunyijia.navigationmenubar.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.sunyijia.navigationmenubar.R;
import com.sunyijia.navigationmenubar.adapter.MyViewPagerAdapter;
import com.sunyijia.navigationmenubar.fragment.FirstFragment;
import com.sunyijia.navigationmenubar.fragment.SecondFragment;
import com.sunyijia.navigationmenubar.fragment.ThirdFragment;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BottomNavigationViewActivity extends AppCompatActivity {

    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.bnv)
    BottomNavigationView bnv;

    private String[] textViewArray = {"美女", "足球", "旅游"};
    private Class[] fragmentClass = {FirstFragment.class, SecondFragment.class, ThirdFragment.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation_view);
        setTitle("BottomNavigationView");
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getSupportFragmentManager(), Arrays.asList(fragmentClass), Arrays.asList(textViewArray), this);
        vp.setAdapter(adapter);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bnv.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.taobao:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.jingdong:
                        vp.setCurrentItem(1);
                        break;
                    case R.id.yamaxun:
                        vp.setCurrentItem(2);
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
    }
}
