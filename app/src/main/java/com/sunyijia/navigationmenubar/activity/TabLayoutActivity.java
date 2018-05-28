package com.sunyijia.navigationmenubar.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.sunyijia.navigationmenubar.R;
import com.sunyijia.navigationmenubar.adapter.MyViewPagerAdapter;
import com.sunyijia.navigationmenubar.fragment.FirstFragment;
import com.sunyijia.navigationmenubar.fragment.SecondFragment;
import com.sunyijia.navigationmenubar.fragment.ThirdFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TabLayoutActivity extends AppCompatActivity {

    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    private String[] textViewArray = {"美女", "足球", "旅游"};
    private Class[] fragmentClass = {FirstFragment.class, SecondFragment.class, ThirdFragment.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);
        setTitle("TabLayout");
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getSupportFragmentManager(), fragmentClass, textViewArray, this);
        vp.setAdapter(adapter);
        tabLayout.setupWithViewPager(vp);
        for (int i = 0; i < adapter.getCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) {
                tab.setCustomView(adapter.getTabView(i));
            }
        }
    }
}
