package com.vincent.tabdemo.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 创建者     Vincent
 * 创建时间   2016/7/8 23:49
 * 描述	      ${TODO}
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class QuestionFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /**
         模拟数据
         */
        TextView textView = new TextView(getContext());
        textView.setText(getClass().getSimpleName());
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(19);
        textView.setTextColor(Color.RED);
        return textView;
    }
}
