package com.example.yrx217.Common;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 摩尔那个点 on 2019/10/2.
 */

public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getContentViewId(),container,false);
        ButterKnife.bind(this,view);
        initView(view);
        initData();
        return view;
    }

    protected void initData(){}

    protected void initView(View view){}

    public abstract int getContentViewId();

    public void toastShort(String msg){
        Toast.makeText(getActivity(),msg,Toast.LENGTH_SHORT).show();
    }

    public void toastLong(String msg){
        Toast.makeText(getActivity(),msg,Toast.LENGTH_LONG).show();
    }


}

