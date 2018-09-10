package com.ldlywt.hello.ui.home;

import com.blankj.utilcode.util.ToastUtils;
import com.ldlywt.hello.base.BasePresenter;
import com.ldlywt.hello.bean.ArticleListBean;
import com.ldlywt.hello.bean.BannerBean;
import com.ldlywt.hello.bean.BaseResult;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.CallBackProxy;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;
import com.zhouyou.http.model.ApiResult;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

/**
 * <pre>
 *     author : lex
 *     e-mail : ldlywt@163.com
 *     time   : 2018/09/04
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class HomePresenter extends BasePresenter<HomeContract.View> implements HomeContract.Presenter {

    private Disposable mDisposable1;
    private Disposable mDisposable2;

    @Inject
    public HomePresenter() {
    }

    @Override
    public void getArticles(int page) {
        mDisposable1 = EasyHttp
                .get("/article/list/" + page + "/json")
                .execute(new CallBackProxy<BaseResult<ArticleListBean>, ArticleListBean>(new SimpleCallBack<ArticleListBean>() {
                    @Override
                    public void onError(ApiException e) {
                        ToastUtils.showShort(e.getMessage());
                    }

                    @Override
                    public void onSuccess(ArticleListBean articleListBean) {
                        mView.updateArticleView(articleListBean);
                    }
                }) {
                });
    }

    @Override
    public void getBanner() {
        mDisposable2 = EasyHttp
                .get("/banner/json")
                .execute(new CallBackProxy<BaseResult<List<BannerBean>>, List<BannerBean>>(new SimpleCallBack<List<BannerBean>>() {
                    @Override
                    public void onError(ApiException e) {
                        ToastUtils.showShort(e.getMessage());
                    }

                    @Override
                    public void onSuccess(List<BannerBean> bannerBeans) {
                        mView.updateBannerView(bannerBeans);
                    }
                }) {
                });
    }

    @Override
    public void detachView() {
        super.detachView();
        EasyHttp.cancelSubscription(mDisposable1);
        EasyHttp.cancelSubscription(mDisposable2);
    }
}
