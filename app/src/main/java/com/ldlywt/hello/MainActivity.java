package com.ldlywt.hello;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.FragmentUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.ldlywt.hello.base.BaseActivity;
import com.ldlywt.hello.ui.maintab.MainTabData;

import butterknife.BindView;
import io.reactivex.Observable;

public class MainActivity extends BaseActivity {


    @BindView(R.id.bottom_tab)
    android.support.design.widget.TabLayout mTabLayout;
    private Fragment[] mFragments;
    private int curIndex;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        getTitleBar()
                .setCenterTextString("资讯")
                .setCenterTextSize(SizeUtils.dp2px(16))
                .setLeftDrawableLeft(null)
                .setCenterTextColor(R.color.white)
                .setBackColor(R.color.colorPrimary);
    }

    @Override
    protected void initData() {
        mFragments = MainTabData.getFragments("main");
        FragmentUtils.add(getSupportFragmentManager(), mFragments, R.id.fl_container, curIndex);
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                showCurrentFragment(tab.getPosition());
                // Tab 选中之后，改变各个Tab的状态
                for (int i = 0; i < mTabLayout.getTabCount(); i++) {
                    View view = mTabLayout.getTabAt(i).getCustomView();
                    ImageView icon = (ImageView) view.findViewById(R.id.tab_content_image);
                    TextView text = (TextView) view.findViewById(R.id.tab_content_text);
                    if (i == tab.getPosition()) { // 选中状态
                        icon.setImageResource(MainTabData.tabResPressed[i]);
                        text.setTextColor(getResources().getColor(android.R.color.black));
                    } else {// 未选中状态
                        icon.setImageResource(MainTabData.tabResNormal[i]);
                        text.setTextColor(getResources().getColor(android.R.color.darker_gray));
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        // 提供自定义的布局添加Tab
        for (int i = 0; i < 4; i++) {
            mTabLayout.addTab(mTabLayout.newTab().setCustomView(MainTabData.getTabView(this, i)));
        }
    }

    private void showCurrentFragment(int index) {
        FragmentUtils.showHide(curIndex = index, mFragments);
    }

}
