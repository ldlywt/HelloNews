package com.ldlywt.hello.ui.project;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ldlywt.hello.R;
import com.ldlywt.hello.adapter.SpaceDecoration;
import com.ldlywt.hello.base.BaseDaggerFragment;
import com.ldlywt.hello.bean.ArticleListBean;
import com.ldlywt.hello.bean.ProjectBean;
import com.ldlywt.hello.ui.WebActivity;
import com.ldlywt.hello.ui.home.GlideImageLoader;
import com.ldlywt.hello.ui.home.HomeFragment;
import com.scwang.smartrefresh.header.DeliveryHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * <pre>
 *     author : lex
 *     e-mail : ldlywt@163.com
 *     time   : 2018/08/28
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class ProjectFragment extends BaseDaggerFragment<ProjectPresenter> implements ProjectContract.View, OnRefreshListener, OnLoadMoreListener {

    @BindView(R.id.recycleView)
    RecyclerView mRecycleView;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    private int mPage;
    private ProjectAdapter mAdapter;

    public static ProjectFragment newInstance(String from) {
        ProjectFragment fragment = new ProjectFragment();
        Bundle bundle = new Bundle();
        bundle.putString("from", from);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void initData() {
        mPresenter.getProject(mPage);
    }

    @Override
    protected void initView() {
        mRecycleView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        SpaceDecoration itemDecoration = new SpaceDecoration(10);
//        itemDecoration.setPaddingEdgeSide(true);//是否为左右2边添加padding.默认true.
//        itemDecoration.setPaddingStart(true);//是否在给第一行的item添加上padding(不包含header).默认true.
//        itemDecoration.setPaddingHeaderFooter(false);//是否对Header于Footer有效,默认false.
        mRecycleView.addItemDecoration(itemDecoration);
        mAdapter = new ProjectAdapter();
        mAdapter.setOnItemClickListener((adapter, view, position) -> WebActivity.startWebActivity(getActivity(),
                mAdapter.getData().get(position).getLink()));
        mRecycleView.setAdapter(mAdapter);
        mRefreshLayout.setOnRefreshListener(this);
        mRefreshLayout.setOnLoadMoreListener(this);
        mRefreshLayout.setRefreshHeader(new DeliveryHeader(getActivity()));
    }

    @Override
    public int getLayoutId() {
        return R.layout.recycleview;
    }

    @Override
    public void updateProjectView(ProjectBean bean) {
        if (bean.getDatas() == null || bean.getDatas().size() == 0) {
            ToastUtils.showShort("已经是最后一页了");
            mRefreshLayout.finishLoadMore();
            return;
        }
        mAdapter.getRandomHeight(bean.getDatas());
        if (bean.getCurPage() == 1) {
            mRefreshLayout.finishRefresh();
            mAdapter.setNewData(bean.getDatas());
        } else {
            mRefreshLayout.finishLoadMore();
            mAdapter.addData(bean.getDatas());
        }
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        mPresenter.getProject(mPage = 0);
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        mPresenter.getProject(++mPage);
    }


    private class ProjectAdapter extends BaseQuickAdapter<ProjectBean.DatasBean, BaseViewHolder> {

        private List<Integer> mHeights;

        public ProjectAdapter() {
            super(R.layout.item_project_layout);
        }

        public void getRandomHeight(List<ProjectBean.DatasBean> mList) {
            mHeights = new ArrayList<>();
            for (int i = 0; i < mList.size(); i++) {
                //随机的获取一个范围为200-600直接的高度
                mHeights.add((int) (300 + Math.random() * 400));
            }
        }

        @Override
        protected void convert(BaseViewHolder helper, ProjectBean.DatasBean item) {
            helper.setText(R.id.tv_desc,item.getDesc());
            helper.setText(R.id.tv_title,item.getTitle());
            ViewGroup root = helper.getView(R.id.root);
            root.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) (300 + Math.random() * 400)));
            Glide.with(getContext()).load(item.getEnvelopePic()).into((ImageView) helper.getView(R.id.img));
        }


    }
}
