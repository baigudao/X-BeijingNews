package com.jackie.tablayoutviewpager;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 作用：MyFragment
 */
public class MyFragment extends Fragment {

    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    private Context mContext;
    private TextView textView;

    /**
     * 得到标题
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    public MyFragment(String title, String content) {
        this.title = title;
        this.content = content;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //上下文
        mContext = getActivity();
    }

    /**
     * 创建视图
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //创建视图
        View view = View.inflate(mContext, R.layout.activity_fragment, null);
        textView = (TextView) view.findViewById(R.id.tv_content);
        return view;
    }

    /**
     * 绑定数据
     *
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //设置内容
        textView.setText(content);
    }
}