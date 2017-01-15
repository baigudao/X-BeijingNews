package com.jackie.viewpager;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

/**
 * 页面的基类
 * Created by Administrator on 2017/1/16.
 */
public class BasePager {
    /**
     * 视图内容
     */
    private TextView tv_content;

    /**
     * 视图数据
     */
    private String content;

    /**
     * 上下文
     */
    private Context context;

    /**
     * 每个页面的视图
     */
    private View rootView;
    /**
     * 构造方法
     */
    public BasePager (Context context,String content){
        this.context = context;
        this.content = content;
        rootView = initView();
        initData();
    }

    /**
     * 初始化视图
     */
    private View initView() {
        View view = View.inflate(context, R.layout.base_pager, null);
        tv_content = (TextView) view.findViewById(R.id.tv_content);
        return view;
    }

    public void initData(){
        tv_content.setText(content);
    }

    public View getRootView() {
        return rootView;
    }
}
