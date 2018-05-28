package com.sunyijia.navigationmenubar.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

import com.sunyijia.navigationmenubar.R;
import com.sunyijia.navigationmenubar.fragment.FirstFragment;
import com.sunyijia.navigationmenubar.fragment.SecondFragment;
import com.sunyijia.navigationmenubar.fragment.ThirdFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author liuleshuai
 */
public class FragmentTabHostActivity extends AppCompatActivity {

    @BindView(android.R.id.tabhost)
    FragmentTabHost tabhost;

    private String[] textViewArray = {"新闻", "视频", "我的"};
    private Class[] fragmentClass = {FirstFragment.class, SecondFragment.class, ThirdFragment.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_tab_host);
        setTitle("FragmentTabHost");
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        tabhost.setup(this, getSupportFragmentManager(), R.id.real_content);
        int count = textViewArray.length;
        for (int i = 0; i < count; i++) {
            TabHost.TabSpec tabSpec = tabhost.newTabSpec(textViewArray[i]).setIndicator(getItemView(i));
            tabhost.addTab(tabSpec, fragmentClass[i], null);
            tabhost.getTabWidget().getChildTabViewAt(i).setBackgroundResource(R.drawable.tab_item);
        }
    }

    private View getItemView(int i) {
        View view = LayoutInflater.from(this).inflate(R.layout.fragment_tab_host_item, null, false);
        TextView tv = view.findViewById(R.id.tab_textview);
        tv.setText(textViewArray[i]);
        Drawable drawable = ContextCompat.getDrawable(this,R.mipmap.ic_launcher);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        tv.setCompoundDrawables(null, drawable, null, null);
        return view;
    }
}
