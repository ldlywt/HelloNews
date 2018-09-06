package com.ldlywt.hello.ui.tree;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.blankj.utilcode.util.SizeUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ldlywt.hello.R;
import com.ldlywt.hello.adapter.SpaceDecoration;
import com.ldlywt.hello.base.BaseActivity;
import com.ldlywt.hello.bean.ArticleListBean;
import com.ldlywt.hello.bean.BaseResult;
import com.ldlywt.hello.bean.TreeArticleBean;
import com.ldlywt.hello.ui.WebActivity;
import com.ldlywt.hello.ui.home.HomeFragment;
import com.scwang.smartrefresh.header.BezierCircleHeader;
import com.scwang.smartrefresh.header.DeliveryHeader;
import com.scwang.smartrefresh.header.FlyRefreshHeader;
import com.scwang.smartrefresh.header.WaveSwipeHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.CallBackProxy;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TreeChildrenActivity extends BaseActivity implements OnRefreshListener, OnLoadMoreListener {

    public static final String PAGE = "page";
    public static final String TITLE = "TITLE";
    @BindView(R.id.recycleView)
    RecyclerView mRecycleView;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    private int mPage;
    private TreeChildrenAdapter mAdapter;
    private int mId;

    public static void startTreeChildrenActivity(Context context, int id, String name) {
        Intent intent = new Intent(context, TreeChildrenActivity.class);
        intent.putExtra(PAGE, id);
        intent.putExtra(TITLE, name);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.recycleview;
    }

    @Override
    protected void initView() {
        getTitleBar()
                .setCenterTextString(getIntent().getStringExtra(TITLE))
                .setCenterTextSize(18)
                .setLeftDrawableLeft(null)
                .setCenterTextColor(R.color.white)
                .setBackColor(R.color.colorPrimary);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
        SpaceDecoration itemDecoration = new SpaceDecoration(10);
//        itemDecoration.setPaddingEdgeSide(true);//是否为左右2边添加padding.默认true.
//        itemDecoration.setPaddingStart(true);//是否在给第一行的item添加上padding(不包含header).默认true.
//        itemDecoration.setPaddingHeaderFooter(false);//是否对Header于Footer有效,默认false.
        mRecycleView.addItemDecoration(itemDecoration);
        mAdapter = new TreeChildrenAdapter();
//        mAdapter.setLoadMoreView(new CustomLoadMoreView());
//        mAdapter.setOnLoadMoreListener(() -> mPresenter.getArticles(++mPage), mRecycleView);
        mAdapter.setOnItemClickListener((adapter, view, position) -> WebActivity.startWebActivity(this,
                mAdapter.getData().get(position).getLink()));
        mRecycleView.setAdapter(mAdapter);
        mRefreshLayout.setOnRefreshListener(this);
        mRefreshLayout.setOnLoadMoreListener(this);
        mRefreshLayout.setRefreshHeader(new BezierCircleHeader(this));
    }

    @Override
    protected void initData() {
        mId = getIntent().getIntExtra(PAGE, 0);
        getTreeArticle(mPage);
    }

    public void getTreeArticle(int page) {
        EasyHttp
                .get("/article/list/" + page + "/json")
                .params("cid", String.valueOf(mId))
                .execute(new CallBackProxy<BaseResult<TreeArticleBean>, TreeArticleBean>(new SimpleCallBack<TreeArticleBean>() {
                    @Override
                    public void onError(ApiException e) {
                        ToastUtils.showShort(e.getMessage());
                    }

                    @Override
                    public void onSuccess(TreeArticleBean bean) {
                        if (bean.getDatas() == null || bean.getDatas().size() == 0) {
                            ToastUtils.showShort("已经是最后一页了");
                            mRefreshLayout.finishLoadMore();
                            return;
                        }
                        if (bean.getCurPage() == 1) {
                            mRefreshLayout.finishRefresh();
                            mAdapter.setNewData(bean.getDatas());
                        } else {
                            mRefreshLayout.finishLoadMore();
                            mAdapter.addData(bean.getDatas());
                        }
                    }
                }) {
                });
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        getTreeArticle(mPage = 0);
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        getTreeArticle(++mPage);
    }

    private class TreeChildrenAdapter extends BaseQuickAdapter<TreeArticleBean.DatasBean, BaseViewHolder> {

        public TreeChildrenAdapter() {
            super(R.layout.item_article);
        }

        @Override
        protected void convert(BaseViewHolder helper, TreeArticleBean.DatasBean item) {
            helper.setText(R.id.tv_author, item.getAuthor());
            helper.setText(R.id.tv_chapterName, item.getChapterName());
            helper.setText(R.id.tv_niceDate, item.getNiceDate());
            helper.setText(R.id.tv_title, item.getTitle());
        }
    }
}
