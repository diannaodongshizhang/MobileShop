package com.example.yrx217.activtity;

import android.widget.TextView;

import com.example.yrx217.Common.BaseActivity;
import com.example.yrx217.R;

import butterknife.BindView;
import butterknife.OnClick;

public class ChangePwdActivity  extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @Override
    public int getContentViewId() {
        return R.layout.activity_change_pwd;
    }

    @Override
    protected void initView() {
        super.initView();
        tvTitle.setText("修改密码");
    }

    @OnClick(R.id.iv_back)
    void close(){
        finish();
    }

}
