package com.ldlywt.hello.ui.maintab;

import android.os.Bundle;
import android.view.View;

import com.ldlywt.hello.R;
import com.ldlywt.hello.base.BaseFragment;

/**
 * <pre>
 *     author : lex
 *     e-mail : ldlywt@163.com
 *     time   : 2018/08/28
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class ProfileFragment extends BaseFragment {

    public static ProfileFragment newInstance(String from) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle bundle = new Bundle();
        bundle.putString("from", from);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.recycleview;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}
