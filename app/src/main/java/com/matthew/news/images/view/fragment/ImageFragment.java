package com.matthew.news.images.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.matthew.news.R;
import com.matthew.news.beans.ImageBean;
import com.matthew.news.images.adapter.ImageAdapter;
import com.matthew.news.images.presenter.ImagePresenter;
import com.matthew.news.images.presenter.ImagePresenterImpl;
import com.matthew.news.images.view.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Description :
 * Author : Matthew
 */
public class ImageFragment extends Fragment implements ImageView, SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = "ImageFragment";
    private SwipeRefreshLayout mSwipeRefreshWidget;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private ImageAdapter mAdapter;
    private List<ImageBean> mData;
    private ImagePresenter mImagePresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mImagePresenter = new ImagePresenterImpl(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image, null);
        mSwipeRefreshWidget = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_widget);
        mSwipeRefreshWidget.setColorSchemeResources(R.color.primary,
                R.color.primary_dark, R.color.primary_light,
                R.color.accent);
        mSwipeRefreshWidget.setOnRefreshListener(this);

        mRecyclerView = (RecyclerView)view.findViewById(R.id.recycle_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new ImageAdapter(getActivity().getApplicationContext());
        mAdapter.setOnItemClickListener(new ImageAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getActivity(), TAG + "DEBUG -- >" + position, Toast.LENGTH_SHORT).show();
                //Todo:
            }
        });
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnScrollListener(mOnScrollListener);
        onRefresh();
        return view;
    }

    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {

        private int lastVisibleItem;

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
        }

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == RecyclerView.SCROLL_STATE_IDLE
                    && lastVisibleItem + 1 == mAdapter.getItemCount() ) {
                //加载
                Snackbar.make(getActivity().findViewById(R.id.drawer_layout),
                        getString(R.string.image_hit), Snackbar.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    public void onRefresh() {
        mImagePresenter.loadImageList();
    }

    @Override
    public void addImages(List<ImageBean> list) {
        if(mData == null) {
            mData = new ArrayList<>();
        }
        mData.clear();
        mData.addAll(list);
        mAdapter.setData(mData);
    }

    @Override
    public void showProgress() {
        mSwipeRefreshWidget.setRefreshing(true);
    }

    @Override
    public void hideProgress() {
        mSwipeRefreshWidget.setRefreshing(false);
    }

    @Override
    public void showLoadFailMsg() {
        if (isAdded()) {
            View view = getActivity() == null ? mRecyclerView.getRootView() : getActivity().findViewById(R.id.drawer_layout);
            Snackbar.make(view, getString(R.string.load_fail), Snackbar.LENGTH_SHORT).show();
        }
    }
}
