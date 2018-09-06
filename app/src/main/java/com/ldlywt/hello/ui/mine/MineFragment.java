package com.ldlywt.hello.ui.mine;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ldlywt.hello.Constant;
import com.ldlywt.hello.R;
import com.ldlywt.hello.adapter.SpaceDecoration;
import com.ldlywt.hello.base.BaseDaggerFragment;
import com.ldlywt.hello.bean.SettingBean;
import com.ldlywt.hello.bean.UserBean;

import butterknife.BindView;

/**
 * <pre>
 *     author : lex
 *     e-mail : ldlywt@163.com
 *     time   : 2018/08/28
 *     desc   : 测试账号 hellonews   123456
 *     version: 1.0
 * </pre>
 */
public class MineFragment extends BaseDaggerFragment<MinePresenter> implements MineContract.View, BaseQuickAdapter.OnItemClickListener {

    @BindView(R.id.iv_avatar)
    ImageView mIvAvatar;
    @BindView(R.id.tv_name)
    TextView mTvName;
    @BindView(R.id.recyclerView)
    RecyclerView mRecycleView;
    private MineAdapter mAdapter;
    private Handler mHandler = new Handler();

    public static MineFragment newInstance(String from) {
        MineFragment fragment = new MineFragment();
        Bundle bundle = new Bundle();
        bundle.putString("from", from);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void initData() {
        String username = SPUtils.getInstance().getString(Constant.SP_USER_NAME);
        if (TextUtils.isEmpty(username)) {
            mIvAvatar.setImageResource(R.mipmap.tab_noone);
            mTvName.setText("请点击头像登录");
        }
    }

    @Override
    protected void initView() {
        mRecycleView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        SpaceDecoration itemDecoration = new SpaceDecoration(10);
        mRecycleView.addItemDecoration(itemDecoration);
        mAdapter = new MineAdapter();
        mRecycleView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(this);
        mIvAvatar.setOnClickListener(v -> showLoginOrRegisterDialog(false));
    }

    private void showLoginOrRegisterDialog(boolean register) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_login, null);
        EditText etPassword = view.findViewById(R.id.et_password);
        EditText etUserName = view.findViewById(R.id.et_username);
        EditText etRepassword = view.findViewById(R.id.et_repassword);
        etRepassword.setVisibility(register ? View.VISIBLE : View.GONE);
        AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).setTitle(register ? "注册" : "登陆")
                .setView(view)
                .setPositiveButton("确定", null).setNegativeButton("取消", null).show();
        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etUserName.getText().toString().trim())) {
                    ToastUtils.showShort("请输入用户名");
                    return;
                }
                if (TextUtils.isEmpty(etPassword.getText().toString().trim())) {
                    ToastUtils.showShort("请输入密码");
                    return;
                }
                if (etRepassword.getVisibility() == View.VISIBLE && TextUtils.isEmpty(etRepassword.getText().toString().trim())) {
                    ToastUtils.showShort("请再次输入密码");
                    return;
                }
                if (register) {
                    mPresenter.register(etUserName.getText().toString().trim(), etPassword.getText().toString().trim(), etRepassword.getText().toString().trim());
                } else {
                    mPresenter.login(etUserName.getText().toString().trim(), etPassword.getText().toString().trim());
                }
                alertDialog.dismiss();
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    public void updateLoginView(UserBean userBean) {
        ToastUtils.showShort("登陆成功");
        mIvAvatar.setImageResource(R.mipmap.icon_avatar);
        mTvName.setText(userBean.getUsername());
        SPUtils.getInstance().put(Constant.SP_USER_NAME, userBean.getUsername());
        SPUtils.getInstance().put(Constant.SP_USER_PASSWORD, userBean.getPassword());
    }

    @Override
    public void updateLogoutView(String result) {
        AlertDialog logoutDialog = new AlertDialog.Builder(getActivity()).setMessage(result).setPositiveButton("确定", (dialog, which) -> {
            logoutSuccess();
        }).create();
        logoutDialog.show();
        mHandler.postDelayed(() -> {
            logoutDialog.dismiss();
            logoutSuccess();
        }, 1500);
    }

    public void logoutSuccess() {
        mIvAvatar.setImageResource(R.mipmap.tab_noone);
        mTvName.setText("请点击头像登录");
        SPUtils.getInstance().put(Constant.SP_USER_NAME, "");
        SPUtils.getInstance().put(Constant.SP_USER_PASSWORD, "");
    }

    @Override
    public void updateRegisterView(String result) {
        new AlertDialog.Builder(getActivity()).setMessage(result).setPositiveButton("确定", null).create().show();
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        switch (position) {
            case 0:
                if (TextUtils.isEmpty(SPUtils.getInstance().getString(Constant.SP_USER_NAME).trim())) {
                    ToastUtils.showShort("请先登陆再说o(╯□╰)o");
                    return;
                }
                ToastUtils.showShort("该功能正在实现中...");
                break;
            case 1:
                showLoginOrRegisterDialog(true);
                break;
            case 2:
                new AlertDialog
                        .Builder(getActivity())
                        .setTitle("提示")
                        .setMessage("确定要退出登陆？")
                        .setPositiveButton("确定", (dialog, which) -> mPresenter.logout())
                        .setNegativeButton("取消", null)
                        .create()
                        .show();

                break;
        }
    }


    private class MineAdapter extends BaseQuickAdapter<SettingBean, BaseViewHolder> {

        private MineAdapter() {
            super(R.layout.item_setting, MineGenerateData.generateData());
        }

        @Override
        protected void convert(BaseViewHolder helper, SettingBean item) {
            helper.setImageResource(R.id.iv, item.getResourceId());
            helper.setText(R.id.tv, item.getName());
        }
    }
}
