package com.ldlywt.hello.ui.about;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.BarUtils;
import com.ldlywt.hello.R;
import com.ldlywt.hello.base.BaseActivity;
import com.ldlywt.hello.ui.WebActivity;

import butterknife.BindView;
import butterknife.OnClick;


public class AboutActivity extends BaseActivity {
    @BindView(R.id.tv_blog_url)
    TextView tvBlogUrl;
    @BindView(R.id.tv_github_url)
    TextView tvGithubUrl;

    public static void startAboutActivity(Activity activity) {
        Intent intent = new Intent(activity, AboutActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_about;
    }

    @Override
    protected void initView() {
        getTitleBar().setBackColor(R.color.colorPrimary).setCenterTextString("About Me");
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.tv_blog_url, R.id.tv_github_url})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_blog_url:
                WebActivity.startWebActivity(this, tvBlogUrl.getText().toString());
                break;
            case R.id.tv_github_url:
                WebActivity.startWebActivity(this, tvGithubUrl.getText().toString());
                break;
            default:
                break;
        }
    }

}
