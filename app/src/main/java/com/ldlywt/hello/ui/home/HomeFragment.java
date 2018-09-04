package com.ldlywt.hello.ui.home;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.just.agentweb.AgentWeb;
import com.ldlywt.hello.R;
import com.ldlywt.hello.adapter.CustomLoadMoreView;
import com.ldlywt.hello.adapter.SpaceDecoration;
import com.ldlywt.hello.base.BaseDaggerFragment;
import com.ldlywt.hello.bean.ArticleListBean;
import com.ldlywt.hello.ui.WebActivity;
import com.trello.rxlifecycle2.LifecycleTransformer;

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
        }
    }

    @Override
    protected void initView() {
        mRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecycleView.addItemDecoration(new SpaceDecoration(10));
        mAdapter = new ArticleAdapter();
        mRecycleView.setAdapter(mAdapter);
        mAdapter.setLoadMoreView(new CustomLoadMoreView());
        mAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.getArticles(++mPage);
            }
        }, mRecycleView);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                WebActivity.startWebActivity(getActivity(),
                        mAdapter.getData().get(position).getLink(),
                        mAdapter.getData().get(position).getTitle());
            }
        });
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
