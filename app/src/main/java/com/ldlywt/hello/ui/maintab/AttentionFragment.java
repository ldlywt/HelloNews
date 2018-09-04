package com.ldlywt.hello.ui.maintab;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
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
public class AttentionFragment extends BaseFragment {

    public static AttentionFragment newInstance(String from) {
        AttentionFragment fragment = new AttentionFragment();
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
        getView().setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary));
    }

    @Override
    protected void initData() {

    }
}
