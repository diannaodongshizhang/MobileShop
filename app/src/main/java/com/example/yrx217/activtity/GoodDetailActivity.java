package com.example.yrx217.activtity;

import android.text.TextUtils;
import android.widget.TextView;

import com.example.yrx217.Common.BaseActivity;
import com.example.yrx217.R;

import butterknife.BindView;
import butterknife.OnClick;

public class GoodDetailActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;

    private int goods_id;
    private String goods_name;

    @Override
    public int getContentViewId() {
        return R.layout.activity_goods_detail;
    }

    @Override
    protected void initView() {
        super.initView();
        goods_id=getIntent().getIntExtra("goods_id",0);
        goods_name=getIntent().getStringExtra("goods_name");
        tvTitle.setMaxEms(9);
        tvTitle.setLines(1);

        if (TextUtils.isEmpty(goods_name)){
            tvTitle.setText("商品详情");
        }else{
            tvTitle.setText(goods_name);
        }
    }

    @OnClick(R.id.iv_back)
    void close(){finish();}
}
