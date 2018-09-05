package com.ldlywt.hello.ui.mine;

import com.blankj.utilcode.util.ToastUtils;
import com.ldlywt.hello.base.BasePresenter;
import com.ldlywt.hello.bean.BannerBean;
import com.ldlywt.hello.bean.BaseResult;
import com.ldlywt.hello.bean.UserBean;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.CallBackProxy;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import javax.inject.Inject;


/**
 * <pre>
 *     author : lex
 *     e-mail : ldlywt@163.com
 *     time   : 2018/09/05
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class MinePresenter extends BasePresenter<MineContract.View> implements MineContract.Presenter {

    @Inject
    MinePresenter() {
    }

    @Override
    public void login(String username, String password) {
        EasyHttp
                .post("/user/login")
                .params("username", username)
                .params("password", password)
                .execute(new CallBackProxy<BaseResult<UserBean>, UserBean>(new SimpleCallBack<UserBean>() {
                    @Override
                    public void onError(ApiException e) {
                        ToastUtils.showShort(e.getMessage());
                    }

                    @Override
                    public void onSuccess(UserBean userBean) {
                        mView.updateLoginView(userBean);
                    }
                }) {
                });
    }

    @Override
    public void logout() {
        EasyHttp
                .get("/user/logout/json")
                .execute(new SimpleCallBack<Object>() {

                    @Override
                    public void onError(ApiException e) {
                        mView.updateLogoutView("已经退出登陆");
                    }

                    @Override
                    public void onSuccess(Object o) {
                        mView.updateLogoutView("已经退出登陆");

                    }
                });
    }

    @Override
    public void register(String username, String password, String repassword) {
        EasyHttp
                .post("/user/register")
                .params("username", username)
                .params("password", password)
                .params("repassword", repassword)
                .execute(new CallBackProxy<BaseResult<UserBean>, UserBean>(new SimpleCallBack<UserBean>() {
                    @Override
                    public void onError(ApiException e) {
                        ToastUtils.showShort(e.getMessage());
                    }

                    @Override
                    public void onSuccess(UserBean userBean) {
                        if (userBean != null) {
                            mView.updateRegisterView("注册成功！");
                        } else {
                            mView.updateRegisterView("注册失败！");
                        }
                    }
                }) {
                });
    }
}
