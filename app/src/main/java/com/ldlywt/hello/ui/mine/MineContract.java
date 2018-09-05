package com.ldlywt.hello.ui.mine;

import com.ldlywt.hello.base.BaseContract;
import com.ldlywt.hello.bean.ArticleListBean;
import com.ldlywt.hello.bean.BannerBean;
import com.ldlywt.hello.bean.UserBean;

import java.util.List;

/**
 * <pre>
 *     author : lex
 *     e-mail : ldlywt@163.com
 *     time   : 2018/09/04
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class MineContract {

    interface View extends BaseContract.BaseView {
        void updateLoginView(UserBean userBean);

        void updateLogoutView(String result);

        void updateRegisterView(String result);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void login(String username, String password);

        void logout();

        void register(String username, String password, String repassword);
    }

}
