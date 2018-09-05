package com.ldlywt.hello.ui.tree;

import android.os.Bundle;


import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;
import com.ldlywt.hello.R;
import com.ldlywt.hello.base.BaseDaggerFragment;
import com.ldlywt.hello.base.BaseFragment;
import com.ldlywt.hello.bean.TreeBean;
import com.ldlywt.hello.ui.tree.adapter.HorizontalPagerAdapter;

import java.util.List;


/**
 * <pre>
 *     author : lex
 *     e-mail : ldlywt@163.com
 *     time   : 2018/08/28
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class TreeFragment extends BaseDaggerFragment<TreePresenter> implements TreeContract.View {

    private HorizontalPagerAdapter mPagerAdapter;

    public static TreeFragment newInstance(String from) {
        TreeFragment fragment = new TreeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("from", from);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void initData() {
        mPresenter.getTree();
    }

    @Override
    protected void initView() {
        final HorizontalInfiniteCycleViewPager horizontalInfiniteCycleViewPager =
                (HorizontalInfiniteCycleViewPager) getView().findViewById(R.id.hicvp);
        mPagerAdapter = new HorizontalPagerAdapter(getContext());
        horizontalInfiniteCycleViewPager.setAdapter(mPagerAdapter);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_tree;
    }

    @Override
    public void updateTreeView(List<TreeBean> data) {
        mPagerAdapter.setList(data);
        mPagerAdapter.notifyDataSetChanged();
    }

    @Override
    public void updateArticleView(String result) {

    }

    @Override
    public void updateRegisterView(String result) {

    }
}
