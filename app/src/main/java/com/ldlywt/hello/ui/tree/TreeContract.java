package com.ldlywt.hello.ui.tree;

import com.ldlywt.hello.base.BaseContract;
import com.ldlywt.hello.bean.TreeBean;
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
public class TreeContract {

    interface View extends BaseContract.BaseView {
        void updateTreeView(List<TreeBean> data);

        void updateArticleView(String result);

        void updateRegisterView(String result);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void getTree();

        void getTreeArticle(int id, int page);
    }

}
