package com.ldlywt.hello.ui.tree;

import com.blankj.utilcode.util.ToastUtils;
import com.ldlywt.hello.base.BasePresenter;
import com.ldlywt.hello.bean.BaseResult;
import com.ldlywt.hello.bean.TreeArticleBean;
import com.ldlywt.hello.bean.TreeBean;
import com.ldlywt.hello.bean.UserBean;
import com.ldlywt.hello.ui.mine.MineContract;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.CallBackProxy;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.List;

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
public class TreePresenter extends BasePresenter<TreeContract.View> implements TreeContract.Presenter {

    @Inject
    TreePresenter() {
    }


    @Override
    public void getTree() {
        EasyHttp
                .get("/tree/json")
                .execute(new CallBackProxy<BaseResult<List<TreeBean>>, List<TreeBean>>(new SimpleCallBack<List<TreeBean>>() {
                    @Override
                    public void onError(ApiException e) {
                        ToastUtils.showShort(e.getMessage());
                    }

                    @Override
                    public void onSuccess(List<TreeBean> bean) {
                        mView.updateTreeView(bean);
                    }
                }) {
                });
    }

    @Override
    public void getTreeArticle(int id, int page) {
        EasyHttp
                .get("/article/list/" + page + "/json")
                .params("cid", String.valueOf(id))
                .execute(new CallBackProxy<BaseResult<TreeArticleBean>, TreeArticleBean>(new SimpleCallBack<TreeArticleBean>() {
                    @Override
                    public void onError(ApiException e) {
                        ToastUtils.showShort(e.getMessage());
                    }

                    @Override
                    public void onSuccess(TreeArticleBean bean) {

                    }
                }) {
                });
    }
}
