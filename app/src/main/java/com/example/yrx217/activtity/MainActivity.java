package com.example.yrx217.activtity;


import android.support.annotation.LayoutRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;


import com.example.yrx217.Common.BaseActivity;
import com.example.yrx217.R;
import com.example.yrx217.fragment.NavigationFragment;

public class MainActivity extends BaseActivity{




    @Override
    public @LayoutRes
    int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fl_main,new NavigationFragment());
        transaction.commit();
    }
}

