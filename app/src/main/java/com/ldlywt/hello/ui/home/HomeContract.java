package com.ldlywt.hello.ui.home;

import com.ldlywt.hello.base.BaseContract;
import com.ldlywt.hello.bean.ArticleListBean;
import com.ldlywt.hello.bean.BannerBean;

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
public class HomeContract {

    interface View extends BaseContract.BaseView {
        void updateArticleView(List<ArticleListBean.DatasBean> datas);
        void updateBannerView(List<BannerBean> bannerBeans);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void getArticles(int page);
        void getBanner();
    }

}
