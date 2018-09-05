package com.ldlywt.hello.ui.mine;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Gravity;
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
import com.ldlywt.xdialog.XDialog;
import butterknife.BindView;


import static com.chad.library.adapter.base.listener.SimpleClickListener.TAG;

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
        mIvAvatar.setOnClickListener(v -> showLoginDialog());
    }

    private void showLoginDialog() {
        //弹窗隐藏时回调方法
        //View控件点击事件回调
        View dialog = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_login, null);
        XDialog xDialog = new XDialog.Builder(getFragmentManager())
                .setView(dialog)
//                .setView(view)  //设置弹窗布局,直接传入View
                .setWidth(600)  //设置弹窗宽度(px)
//                .setHeight(800)  //设置弹窗高度(px)
                .setScreenWidthAspect(getActivity(), 0.8f)   //设置弹窗宽度(参数aspect为屏幕宽度比例 0 - 1f)
//                .setScreenHeightAspect(mActivity, 0.3f)  //设置弹窗高度(参数aspect为屏幕宽度比例 0 - 1f)
                .setGravity(Gravity.CENTER)     //设置弹窗展示位置
                .setTag(TAG)   //设置Tag
                .setDimAmount(0.6f)     //设置弹窗背景透明度(0-1f)
                .setCancelableOutside(true)     //弹窗在界面外是否可以点击取消
                .setDialogAnimationRes(R.style.animate_dialog_scale) //设置弹窗动画)
                .create()
                .show();
        EditText etPassword = dialog.findViewById(R.id.et_password);
        EditText etUserName = dialog.findViewById(R.id.et_username);
        dialog.findViewById(R.id.bt_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etUserName.getText().toString().trim())) {
                    ToastUtils.showShort("请输入用户名");
                    xDialog.dismiss();
                    return;
                }
                if (TextUtils.isEmpty(etPassword.getText().toString().trim())) {
                    ToastUtils.showShort("请输入密码");
                    xDialog.dismiss();
                    return;
                }
                mPresenter.login(etUserName.getText().toString().trim(), etPassword.getText().toString().trim());
                xDialog.dismiss();
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

                break;
            case 1:

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
