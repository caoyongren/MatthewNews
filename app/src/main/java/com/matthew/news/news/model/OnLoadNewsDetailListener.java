package com.matthew.news.news.model;

import com.matthew.news.beans.NewsDetailBean;


public interface OnLoadNewsDetailListener {

    void onSuccess(NewsDetailBean newsDetailBean);

    void onFailure(String msg, Exception e);
}
