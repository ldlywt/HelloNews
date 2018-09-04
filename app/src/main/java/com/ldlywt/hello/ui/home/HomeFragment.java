package com.ldlywt.hello.ui.home;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ldlywt.hello.R;
import com.ldlywt.hello.adapter.CustomLoadMoreView;
import com.ldlywt.hello.adapter.SpaceDecoration;
import com.ldlywt.hello.base.BaseDaggerFragment;
import com.ldlywt.hello.bean.ArticleListBean;
import com.ldlywt.hello.bean.BannerBean;
import com.ldlywt.hello.ui.WebActivity;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * <pre>
 *     author : lex
 *     e-mail : ldlywt@163.com
 *     time   : 2018/08/28
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class HomeFragment extends BaseDaggerFragment<HomePresenter> implements HomeContract.View {

    @BindView(R.id.recycleView)
    RecyclerView mRecycleView;

    private int mPage;
    private ArticleAdapter mAdapter;
    private List<String> mBannerBeans = new ArrayList<>();
    private Banner mBanner;

    public static HomeFragment newInstance(String from) {
        HomeFragment fragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("from", from);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void initData() {
        if (mPresenter != null) {
            mPresenter.getArticles(mPage);
            mPresenter.getBanner();
        }
    }

    @Override
    protected void initView() {
        mRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        SpaceDecoration itemDecoration = new SpaceDecoration(10);
//        itemDecoration.setPaddingEdgeSide(true);//是否为左右2边添加padding.默认true.
//        itemDecoration.setPaddingStart(true);//是否在给第一行的item添加上padding(不包含header).默认true.
//        itemDecoration.setPaddingHeaderFooter(false);//是否对Header于Footer有效,默认false.
        mRecycleView.addItemDecoration(itemDecoration);
        mAdapter = new ArticleAdapter();
        mAdapter.setLoadMoreView(new CustomLoadMoreView());
        mAdapter.setOnLoadMoreListener(() -> mPresenter.getArticles(++mPage), mRecycleView);
        mAdapter.setOnItemClickListener((adapter, view, position) -> WebActivity.startWebActivity(getActivity(),
                mAdapter.getData().get(position).getLink()));
        View headerView = getHeaderView();
        mAdapter.addHeaderView(headerView);
        mRecycleView.setAdapter(mAdapter);
    }

    private View getHeaderView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.home_banner, null);
        mBanner = view.findViewById(R.id.banner);
        return view;
    }

    @Override
    public int getLayoutId() {
        return R.layout.recycleview;
    }

    @Override
    public void updateArticleView(List<ArticleListBean.DatasBean> datas) {
        mAdapter.loadMoreComplete();
        mAdapter.addData(datas);
    }

    @Override
    public void updateBannerView(List<BannerBean> bannerBeans) {
        mBannerBeans.clear();
        for (BannerBean bean : bannerBeans) {
            mBannerBeans.add(bean.getImagePath());
        }
        mBanner.setImages(mBannerBeans)
                .setImageLoader(new GlideImageLoader())
                .setOnBannerListener(new OnBannerListener() {
                    @Override
                    public void OnBannerClick(int position) {
                        WebActivity.startWebActivity(getActivity(),
                                bannerBeans.get(position).getUrl());
                    }
                })
                .start();
    }

    private class ArticleAdapter extends BaseQuickAdapter<ArticleListBean.DatasBean, BaseViewHolder> {

        public ArticleAdapter() {
            super(R.layout.item_article);
        }

        @Override
        protected void convert(BaseViewHolder helper, ArticleListBean.DatasBean item) {
            helper.setText(R.id.tv_author, item.getAuthor());
            helper.setText(R.id.tv_chapterName, item.getChapterName());
            helper.setText(R.id.tv_niceDate, item.getNiceDate());
            helper.setText(R.id.tv_title, item.getTitle());
        }
    }
}
