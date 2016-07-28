package com.vincent.tabdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;
import com.vincent.tabdemo.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 创建者     Vincent
 * 创建时间   2016/7/8 23:49
 * 描述	     综合模块
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class NewsFragment extends Fragment {
    @InjectView(R.id.pagertab)
    PagerSlidingTabStrip mPagertab;
    @InjectView(R.id.viewpager)
    ViewPager mViewpager;

    // private final String[] title = {"首页", "热点", "财经", "娱乐", "军事", "政治", "生活"};
    private final String[] title = {"首页", "热点", "财经"};
    AFragment af;
    BFragment bf;
    CFragment cf;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.newsfragment_layout, null);
        ButterKnife.inject(this, rootView);

        initView();
        return rootView;
    }


    private void initView() {

        mViewpager.setAdapter(new MyPagerAdapter(getChildFragmentManager(), title));
        mPagertab.setViewPager(mViewpager);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        String[] _title;

        public MyPagerAdapter(FragmentManager fm, String[] title) {
            super(fm);
            _title = title;
        }

        @Override
        public int getCount() {
            return _title.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return _title[position];
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    if (af == null) {
                        af = new AFragment(_title);
                    }
                    return af;
                case 1:
                    if (bf == null) {
                        bf = new BFragment(_title);
                    }
                    return bf;
                case 2:
                    if (cf == null) {
                        cf = new CFragment(_title);
                    }
                    return cf;

                default:
                    return null;
            }
        }
    }
}
