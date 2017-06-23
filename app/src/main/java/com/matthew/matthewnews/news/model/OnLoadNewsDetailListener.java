package com.matthew.matthewnews.news.model;

import com.matthew.matthewnews.beans.NewsDetailBean;


public interface OnLoadNewsDetailListener {

    void onSuccess(NewsDetailBean newsDetailBean);

    void onFailure(String msg, Exception e);
}
