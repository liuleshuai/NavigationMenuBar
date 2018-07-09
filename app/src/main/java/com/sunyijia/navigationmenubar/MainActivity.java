package com.sunyijia.navigationmenubar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.sunyijia.navigationmenubar.activity.BottomNavigationViewActivity;
import com.sunyijia.navigationmenubar.activity.FragmentTabHost2Activity;
import com.sunyijia.navigationmenubar.activity.FragmentTabHostActivity;
import com.sunyijia.navigationmenubar.activity.TabLayoutActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.FragmentTabHost)
    Button FragmentTabHost;
    @BindView(R.id.TabLayout)
    Button TabLayout;
    @BindView(R.id.BottomNavigationView)
    Button BottomNavigationView;
    @BindView(R.id.Tabvp)
    Button Tabvp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.FragmentTabHost,R.id.Tabvp, R.id.TabLayout, R.id.BottomNavigationView})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.FragmentTabHost:
                startActivity(new Intent(MainActivity.this, FragmentTabHostActivity.class));
                break;
            case R.id.Tabvp:
                startActivity(new Intent(MainActivity.this, FragmentTabHost2Activity.class));
                break;
            case R.id.TabLayout:
                startActivity(new Intent(MainActivity.this, TabLayoutActivity.class));
                break;
            case R.id.BottomNavigationView:
                startActivity(new Intent(MainActivity.this, BottomNavigationViewActivity.class));
                break;
            default:
                break;
        }
    }
}
