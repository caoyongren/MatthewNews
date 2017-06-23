package com.matthew.matthewnews.news.presenter;

import android.content.Context;

import com.matthew.matthewnews.beans.NewsDetailBean;
import com.matthew.matthewnews.news.model.NewsModel;
import com.matthew.matthewnews.news.model.NewsModelImpl;
import com.matthew.matthewnews.news.model.OnLoadNewsDetailListener;
import com.matthew.matthewnews.news.view.NewsDetailView;

public class NewsDetailPresenterImpl implements NewsDetailPresenter, OnLoadNewsDetailListener {

    private Context mContent;
    private NewsDetailView mNewsDetailView;
    private NewsModel mNewsModel;

    public NewsDetailPresenterImpl(Context mContent, NewsDetailView mNewsDetailView) {
        this.mContent = mContent;
        this.mNewsDetailView = mNewsDetailView;
        mNewsModel = new NewsModelImpl();
    }

    @Override
    public void loadNewsDetail(final String docId) {
        mNewsDetailView.showProgress();
        mNewsModel.loadNewsDetail(docId, this);
    }


    @Override
    public void onSuccess(NewsDetailBean newsDetailBean) {
        if (newsDetailBean != null) {
            mNewsDetailView.showNewsDetialContent(newsDetailBean.getBody());
        }
        mNewsDetailView.hideProgress();
    }

    @Override
    public void onFailure(String msg, Exception e) {
        mNewsDetailView.hideProgress();
    }
}
