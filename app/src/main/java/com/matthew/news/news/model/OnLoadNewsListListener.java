package com.matthew.news.news.model;


import com.matthew.news.beans.NewsBean;

import java.util.List;


public interface OnLoadNewsListListener {

    void onSuccess(List<NewsBean> list);

    void onFailure(String msg, Exception e);
}
