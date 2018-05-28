package com.sunyijia.navigationmenubar.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sunyijia.navigationmenubar.R;

public class MyViewPagerAdapter extends FragmentPagerAdapter {
    private Class[] fragmentClass;
    private String[] textArray;
    private Context mContext;

    public MyViewPagerAdapter(FragmentManager fm, Class[] fragmentClass, String[] textArray, Context mContext) {
        super(fm);
        this.fragmentClass = fragmentClass;
        this.textArray = textArray;
        this.mContext = mContext;
    }

    @Override
    public Fragment getItem(int position) {
        return Fragment.instantiate(mContext, fragmentClass[position].getCanonicalName());
    }

    @Override
    public int getCount() {
        return textArray.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }

    public View getTabView(int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.tab_layout_item, null, false);
        TextView tv = view.findViewById(R.id.tv);
        ImageView iv = view.findViewById(R.id.iv);
        tv.setText(textArray[i]);
        return view;
    }
}
