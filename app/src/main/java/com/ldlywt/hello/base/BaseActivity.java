package com.ldlywt.hello.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.blankj.utilcode.util.SizeUtils;
import com.ldlywt.hello.App;
import com.ldlywt.hello.R;
import com.ldlywt.hello.view.CommonTextView;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author wong
 */
public abstract class BaseActivity extends RxAppCompatActivity implements BaseContract.BaseView {
    protected BaseActivity mActivity = BaseActivity.this;
    private Unbinder unbinder;
    private CommonTextView mTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layoutId = getLayoutId();
        setContentView(layoutId);
        unbinder = ButterKnife.bind(this);
        initTitle();
        initView();
        initData();
    }

    protected abstract int getLayoutId();

    protected void initTitle() {
        mTitle = new CommonTextView(this);
        mTitle
                .setLeftDrawableLeft(ContextCompat.getDrawable(this, R.drawable.ic_back_white))
                .setWidthAndHeight(LinearLayout.LayoutParams.MATCH_PARENT, SizeUtils.dp2px(40))
//                .setLeftTextString(getResources().getString(R.string.back))
                .setLeftTextColor(android.R.color.white)
                .setLeftViewIsClickable(true)
                .setOnCommonTextViewClickListener(new CommonTextView.OnCommonTextViewClickListener() {
                    @Override
                    public void onLeftViewClick() {
                        BaseActivity.super.onBackPressed();
                    }
                })
        ;
        ViewGroup decorView = (ViewGroup) getWindow().getDecorView();
        ViewGroup viewGroup = (ViewGroup) decorView.getChildAt(0);
        viewGroup.addView(mTitle, 0);
    }

    protected abstract void initView();

    protected abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    protected CommonTextView getTitleBar() {
        return mTitle;
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
