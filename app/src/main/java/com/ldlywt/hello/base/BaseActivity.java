package com.ldlywt.hello.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.ldlywt.hello.App;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author wong
 */
public abstract class BaseActivity extends RxAppCompatActivity implements BaseContract.BaseView {
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layoutId = getLayoutId();
        setContentView(layoutId);
        unbinder = ButterKnife.bind(this);
        initView();
        initData();
    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void showLoading() {
        Toast.makeText(App.getInstance(), "显示进度条", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideLoading() {
        Toast.makeText(App.getInstance(), "隐藏进度条", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSuccess() {
    }

    @Override
    public void showFailed() {
        Toast.makeText(App.getInstance(), "加载失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showNoNet() {
        Toast.makeText(App.getInstance(), "无网络链接", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRetry() {
    }

    @Override
    public <T> LifecycleTransformer<T> bindToLife() {
        return this.bindToLifecycle();
    }
}
