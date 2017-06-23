package com.matthew.matthewnews.news.model;


import com.matthew.matthewnews.beans.NewsBean;

import java.util.List;


public interface OnLoadNewsListListener {

    void onSuccess(List<NewsBean> list);

    void onFailure(String msg, Exception e);
}
