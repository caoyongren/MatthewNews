package com.matthew.matthewnews.news.model;


public interface NewsModel {

    void loadNews(String url, int type, OnLoadNewsListListener listener);

    void loadNewsDetail(String docid, com.matthew.matthewnews.news.model.OnLoadNewsDetailListener listener);

}
